package com.neshan.reportservice.util;

import com.neshan.reportservice.mapper.ReportMapper;
import com.neshan.reportservice.model.dto.CreateReportDto;
import com.neshan.reportservice.model.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ReportFactory {

    private ReportMapper reportMapper;

    public Report getReportByTitle(CreateReportDto createReportDto) {

        Report report;
        switch (createReportDto.title()) {
            case ACCIDENT -> report = reportMapper.ReportDtoToAccidentReport(createReportDto);
            case CAMERA -> report = reportMapper.ReportDtoToCameraReport(createReportDto);
            case MAP_BUGS -> report = reportMapper.ReportDtoToMapBugsReport(createReportDto);
            case POLICE -> report = reportMapper.ReportDtoToPoliceReport(createReportDto);
            case TRAFFIC -> report = reportMapper.ReportDtoToTrafficReport(createReportDto);
            case SPEED_BUMP -> report = reportMapper.ReportDtoToSpeedBumpReport(createReportDto);
            case WAY_EVENTS -> report = reportMapper.ReportDtoToWayEventsReport(createReportDto);
            case ROAD_LOCATIONS -> report = reportMapper.ReportDtoToRoadLocationsReport(createReportDto);
            case WEATHER_CONDITIONS -> report = reportMapper.ReportDtoToWeatherConditionsReport(createReportDto);
            default -> throw new IllegalArgumentException("Invalid report title!");
        }
        return report;
    }
}
