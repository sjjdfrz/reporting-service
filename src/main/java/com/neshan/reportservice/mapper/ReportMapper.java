package com.neshan.reportservice.mapper;

import com.neshan.reportservice.model.Point;
import com.neshan.reportservice.model.dto.ReportDto;
import com.neshan.reportservice.model.entity.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    AccidentReport ReportDtoToAccidentReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    CameraReport ReportDtoToCameraReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    MapBugsReport ReportDtoToMapBugsReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    PoliceReport ReportDtoToPoliceReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    RoadLocationsReport ReportDtoToRoadLocationsReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    SpeedBumpReport ReportDtoToSpeedBumpReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    TrafficReport ReportDtoToTrafficReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    WayEventsReport ReportDtoToWayEventsReport(ReportDto reportDto);

    @Mapping(target = "location", expression = "java(mapPointToJtsPoint(reportDto.location()))")
    @ValueMapping(target = MappingConstants.NULL, source = MappingConstants.ANY_REMAINING)
    WeatherConditionsReport ReportDtoToWeatherConditionsReport(ReportDto reportDto);

    default org.locationtech.jts.geom.Point mapPointToJtsPoint(Point location) {

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(location.latitude(), location.longitude());
        org.locationtech.jts.geom.Point point = geometryFactory.createPoint(coordinate);
        point.setSRID(4326);
        return point;
    }
}
