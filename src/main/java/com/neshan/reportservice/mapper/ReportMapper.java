package com.neshan.reportservice.mapper;

import com.neshan.reportservice.model.dto.GetReportDto;
import com.neshan.reportservice.model.dto.report.*;
import com.neshan.reportservice.model.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "location", expression = "java(report.getLocation().toString())")
    GetReportDto reportToReportDto(Report report);

    default Report reportDtoToReport(ReportDto reportDto) {

        return switch (reportDto.getTitle()) {

            case ACCIDENT -> ReportDtoToAccidentReport((AccidentReportDto) reportDto);
            case CAMERA -> ReportDtoToCameraReport((CameraReportDto) reportDto);
            case MAP_BUGS -> ReportDtoToMapBugsReport((MapBugsReportDto) reportDto);
            case POLICE -> ReportDtoToPoliceReport((PoliceReportDto) reportDto);
            case ROAD_LOCATIONS -> ReportDtoToRoadLocationsReport((RoadLocationsReportDto) reportDto);
            case SPEED_BUMP -> ReportDtoToSpeedBumpReport((SpeedBumpReportDto) reportDto);
            case TRAFFIC -> ReportDtoToTrafficReport((TrafficReportDto) reportDto);
            case WAY_EVENTS -> ReportDtoToWayEventsReport((WayEventsReportDto) reportDto);
            case WEATHER_CONDITIONS -> ReportDtoToWeatherConditionsReport((WeatherConditionsReportDto) reportDto);
        };
    }

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(accidentReportDto.getLocation()))")
    AccidentReport ReportDtoToAccidentReport(AccidentReportDto accidentReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(cameraReportDto.getLocation()))")
    CameraReport ReportDtoToCameraReport(CameraReportDto cameraReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(mapBugsReportDto.getLocation()))")
    MapBugsReport ReportDtoToMapBugsReport(MapBugsReportDto mapBugsReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(policeReportDto.getLocation()))")
    PoliceReport ReportDtoToPoliceReport(PoliceReportDto policeReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(roadLocationsReportDto.getLocation()))")
    RoadLocationsReport ReportDtoToRoadLocationsReport(RoadLocationsReportDto roadLocationsReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(speedBumpReportDto.getLocation()))")
    SpeedBumpReport ReportDtoToSpeedBumpReport(SpeedBumpReportDto speedBumpReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(trafficReportDto.getLocation()))")
    TrafficReport ReportDtoToTrafficReport(TrafficReportDto trafficReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(wayEventsReportDto.getLocation()))")
    WayEventsReport ReportDtoToWayEventsReport(WayEventsReportDto wayEventsReportDto);

    @Mapping(target = "location", expression = "java(com.neshan.reportservice.util.PointConvertor.customPointToJtsPoint(weatherConditionsReportDto.getLocation()))")
    WeatherConditionsReport ReportDtoToWeatherConditionsReport(WeatherConditionsReportDto weatherConditionsReportDto);
}
