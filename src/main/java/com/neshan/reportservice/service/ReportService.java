package com.neshan.reportservice.service;

import com.neshan.reportservice.exception.NoSuchElementFoundException;
import com.neshan.reportservice.mapper.ReportMapper;
import com.neshan.reportservice.model.dto.FeedbackDto;
import com.neshan.reportservice.model.dto.ReportDto;
import com.neshan.reportservice.model.dto.ReportsDto;
import com.neshan.reportservice.model.dto.RoutingDto;
import com.neshan.reportservice.model.entity.Report;
import com.neshan.reportservice.model.enums.FeedbackAction;
import com.neshan.reportservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    public void createReport(ReportDto reportDto) {

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(
                reportDto.location().latitude(), reportDto.location().longitude());
        Point location = geometryFactory.createPoint(coordinate);
        location.setSRID(4326);

        if (reportRepository.existsDuplicateReport(location, reportDto.type().getCode(), 2)) {
            throw new RuntimeException("Duplicate Report!");
        }

        Report report;

        switch (reportDto.title()) {
            case ACCIDENT -> {
                report = reportMapper.ReportDtoToAccidentReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(1));
            }
            case CAMERA -> {
                report = reportMapper.ReportDtoToCameraReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(8));
            }
            case MAP_BUGS -> {
                report = reportMapper.ReportDtoToMapBugsReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(9));
            }
            case POLICE -> {
                report = reportMapper.ReportDtoToPoliceReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(7));
            }
            case TRAFFIC -> {
                report = reportMapper.ReportDtoToTrafficReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(11));
            }
            case SPEED_BUMP -> {
                report = reportMapper.ReportDtoToSpeedBumpReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(6));
            }
            case WAY_EVENTS -> {
                report = reportMapper.ReportDtoToWayEventsReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(4));
            }
            case ROAD_LOCATIONS -> {
                report = reportMapper.ReportDtoToRoadLocationsReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(5));
            }
            case WEATHER_CONDITIONS -> {
                report = reportMapper.ReportDtoToWeatherConditionsReport(reportDto);
                report.setExpiresAt(LocalDateTime.now().plusMinutes(3));
            }
            default -> throw new IllegalArgumentException("Invalid report title!");
        }

        reportRepository.save(report);
    }

    public List<ReportsDto> routing(RoutingDto routingDto) throws ParseException {

        LineString routeLine = (LineString) new WKTReader().read(routingDto.lineString());
        routeLine.setSRID(4326);
        return reportRepository.findAllReportsOfRoute(routeLine);
    }

    public void feedback(long reportId, FeedbackDto feedbackDto) {

        Report report = reportRepository
                .findById(reportId)
                .orElseThrow(() -> new NoSuchElementFoundException(
                        String.format("The report with Id %d was not found.", reportId)));

        if (feedbackDto.action() == FeedbackAction.LIKE) {

            report.setExpiresAt(report.getExpiresAt().plusMinutes(2));

        } else if (feedbackDto.action() == FeedbackAction.DISLIKE) {
            report.setExpiresAt(report.getExpiresAt().minusMinutes(2));
        }
    }
}
