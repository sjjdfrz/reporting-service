package com.neshan.reportservice.runner;

import com.neshan.reportservice.model.entity.*;
import com.neshan.reportservice.model.enums.AccidentType;
import com.neshan.reportservice.model.enums.TrafficType;
import com.neshan.reportservice.repository.ReportRepository;
import jdk.jfr.Percentage;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class ReportRunner implements CommandLineRunner {

    private final ReportRepository reportRepository;

    @Override
    public void run(String... args) {

//        GeometryFactory geometryFactory = new GeometryFactory();
//
//        AccidentReport accidentReport1 = AccidentReport
//                .builder()
//                .location(geometryFactory.createPoint(new Coordinate(5, 10)))
//                .expiresAt(LocalDateTime.now().plusMinutes(30))
//                .type(AccidentType.HEAVY)
//                .build();
//
//        Report accidentReport2 = AccidentReport
//                .builder()
//                .location(geometryFactory.createPoint(new Coordinate(5, 10)))
//                .expiresAt(LocalDateTime.now().plusMinutes(10))
//                .type(AccidentType.LIGHT)
//                .build();
//
//        Report trafficReport = TrafficReport
//                .builder()
//                .location(geometryFactory.createPoint(new Coordinate(5, 10)))
//                .expiresAt(LocalDateTime.now().plusMinutes(20))
//                .type(TrafficType.SEMI_HEAVY)
//                .build();
//
//        Report speedBumpReport = SpeedBumpReport
//                .builder()
//                .location(geometryFactory.createPoint(new Coordinate(5, 10)))
//                .expiresAt(LocalDateTime.now().plusMinutes(40))
//                .build();
//
//        reportRepository.saveAll(List.of(accidentReport1, trafficReport, accidentReport2, speedBumpReport));
    }
}
