package com.neshan.reportservice.mapper;

import com.neshan.reportservice.model.dto.CreateReportDto;
import com.neshan.reportservice.model.dto.GetReportDto;
import com.neshan.reportservice.model.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "location", expression = "java(report.getLocation().toString())")
    GetReportDto reportToReportDto(Report report);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    AccidentReport ReportDtoToAccidentReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    CameraReport ReportDtoToCameraReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    MapBugsReport ReportDtoToMapBugsReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    PoliceReport ReportDtoToPoliceReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    RoadLocationsReport ReportDtoToRoadLocationsReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    SpeedBumpReport ReportDtoToSpeedBumpReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    TrafficReport ReportDtoToTrafficReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    WayEventsReport ReportDtoToWayEventsReport(CreateReportDto createReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(createReportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    WeatherConditionsReport ReportDtoToWeatherConditionsReport(CreateReportDto createReportDto);
}
