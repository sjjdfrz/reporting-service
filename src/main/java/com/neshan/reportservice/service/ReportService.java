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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

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
    }

    @Transactional
    public void deleteReport(long id) {
        reportRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllReports() {
        reportRepository.deleteAll();
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

        if (action == FeedbackAction.LIKE)
            report.increaseExpiresAt(ReportConstants.likeConstants.get(report.getSubTitle()));
        else
            report.decreaseExpiresAt(ReportConstants.dislikeConstants.get(report.getSubTitle()));
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
        reportRepository.approveReport(reportId, action.name());
    }
}
