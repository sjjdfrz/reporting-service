package com.neshan.reportservice.util;

import com.neshan.reportservice.model.enums.ReportTitle;

import java.util.Map;

public class ReportConstants {

    public static final int ACCIDENT_EXPIRES_AT = 3;
    public static final int CAMERA_EXPIRES_AT = 2;
    public static final int MAP_BUGS_EXPIRES_AT = 4;
    public static final int POLICE_EXPIRES_AT = 3;
    public static final int TRAFFIC_EXPIRES_AT = 5;
    public static final int SPEED_BUMP_EXPIRES_AT = 2;
    public static final int WAY_EVENTS_EXPIRES_AT = 3;
    public static final int ROAD_LOCATIONS_EXPIRES_AT = 4;
    public static final int WEATHER_CONDITIONS_EXPIRES_AT = 2;

    public static final Map<String, Integer> likeConstants = Map.of(
            "accident", 2,
            "camera", 3,
            "map_bugs", 4,
            "police", 6,
            "traffic", 1,
            "speed_bump", 2,
            "way_events", 5,
            "road_locations", 1,
            "weather_conditions", 4
    );

    public static final Map<String, Integer> dislikeConstants = Map.of(
            "accident", 1,
            "camera", 2,
            "map_bugs", 2,
            "police", 3,
            "traffic", 1,
            "speed_bump", 2,
            "way_events", 3,
            "road_locations", 2,
            "weather_conditions", 3
    );

    public static final Map<ReportTitle, Integer> timeDifferenceConstants = Map.of(

            ReportTitle.ACCIDENT, 2,
            ReportTitle.CAMERA, 4,
            ReportTitle.MAP_BUGS, 3,
            ReportTitle.POLICE, 1,
            ReportTitle.TRAFFIC, 5,
            ReportTitle.SPEED_BUMP, 1,
            ReportTitle.WAY_EVENTS, 3,
            ReportTitle.ROAD_LOCATIONS, 2,
            ReportTitle.WEATHER_CONDITIONS, 4
    );
}
