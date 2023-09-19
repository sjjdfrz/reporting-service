package com.neshan.reportservice.service;

import com.neshan.reportservice.exception.DuplicateReportException;
import com.neshan.reportservice.exception.NoSuchElementFoundException;
import com.neshan.reportservice.mapper.ReportMapper;
import com.neshan.reportservice.model.dto.*;
import com.neshan.reportservice.model.entity.Report;
import com.neshan.reportservice.model.entity.User;
import com.neshan.reportservice.model.enums.ApprovalAction;
import com.neshan.reportservice.model.enums.FeedbackAction;
import com.neshan.reportservice.repository.ReportRepository;
import com.neshan.reportservice.util.ReportConstants;
import com.neshan.reportservice.util.ReportFactory;
import com.neshan.reportservice.util.PointConvertor;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;
    private final RedissonClient redissonClient;

    @Transactional
    public List<GetAllReportsDto> getAllReports() {
        return reportRepository.findAllReports();
    }

    @Transactional
    public GetReportDto getReport(long reportId) {

        Report report = reportRepository
                .findById(reportId)
                .orElseThrow(() -> new NoSuchElementFoundException(
                        String.format("The report with ID %d was not found.", reportId)));

        return reportMapper.reportToReportDto(report);
    }

    @Transactional
    public void createReport(CreateReportDto createReportDto, User user) {

        // Check report duplication.
        Point location = PointConvertor.customPointToJtsPoint(createReportDto.location());

        RLock lock = redissonClient.getLock("create-report");

        lock.lock();
        if (reportRepository.existsDuplicateReport(
                location,
                createReportDto.type().getCode(),
                ReportConstants.timeDifferenceConstants.get(createReportDto.title()))) {
            throw new DuplicateReportException("Duplicate Report!");
        }
        ReportFactory reportFactory = new ReportFactory(reportMapper);
        Report report = reportFactory.getReportByTitle(createReportDto);
        report.setUser(user);
        reportRepository.save(report);
        lock.unlock();
    }

    @Transactional
    public void deleteReport(long id) {

        RReadWriteLock rwLock = redissonClient.getReadWriteLock("deleteReportLock-" + id);
        RLock writeLock = rwLock.writeLock();

        writeLock.lock();
        reportRepository.deleteById(id);
        writeLock.unlock();
    }

    @Transactional
    public void deleteAllReports() {

        RLock lock = redissonClient.getLock("deleteAllReports");

        lock.lock();
        reportRepository.deleteAll();
        lock.unlock();
    }

    @Transactional
    public List<RouteReports> routing(RoutingDto routingDto) throws ParseException {

        LineString routeLine = (LineString) new WKTReader().read(routingDto.lineString());
        routeLine.setSRID(4326);
        return reportRepository.findAllReportsOfRoute(routeLine);
    }

    @Transactional
    public void feedback(long reportId, FeedbackAction action) {

        Report report = reportRepository
                .findById(reportId)
                .orElseThrow(() -> new NoSuchElementFoundException(
                        String.format("The report with Id %d was not found.", reportId)));

        RLock lock = redissonClient.getLock("feedbackReportLock-" + reportId);

        lock.lock();
        if (action == FeedbackAction.LIKE)
            report.increaseExpiresAt(ReportConstants.likeConstants.get(report.getSubTitle()));
        else
            report.decreaseExpiresAt(ReportConstants.dislikeConstants.get(report.getSubTitle()));
        lock.unlock();
    }

    @Transactional
    public List<GetAllReportsOfUserDto> getAllReportsOfUser(User user) {
        return reportRepository.findAllReportsByUserId(user.getId());
    }

    @Transactional
    public List<ApprovalReports> getApprovalNeedReports() {
        return reportRepository.findAllApprovedNeedReports();
    }

    @Transactional
    public void approveReport(long reportId, ApprovalAction action) {

        RLock lock = redissonClient.getLock("approveReportLock-" + reportId);

        lock.lock();
        reportRepository.approveReport(reportId, action.name());
        lock.unlock();
    }
}
