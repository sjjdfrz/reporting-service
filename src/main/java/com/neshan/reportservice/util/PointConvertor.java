package com.neshan.reportservice.util;

import com.neshan.reportservice.model.Point;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;

public class PointConvertor {

    public static org.locationtech.jts.geom.Point customPointToJtsPoint(Point location) {

        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(location.latitude(), location.longitude());
        org.locationtech.jts.geom.Point point = geometryFactory.createPoint(coordinate);
        point.setSRID(4326);
        return point;
    }
}
