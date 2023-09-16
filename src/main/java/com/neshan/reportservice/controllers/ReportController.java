package com.neshan.reportservice.controllers;

import com.neshan.reportservice.model.ApiResponse;
import com.neshan.reportservice.model.dto.ReportDto;
import com.neshan.reportservice.model.dto.ReportsDto;
import com.neshan.reportservice.model.dto.RoutingDto;
import com.neshan.reportservice.model.enums.FeedbackAction;
import com.neshan.reportservice.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.io.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/reports")
    public ResponseEntity<ApiResponse<Object>> createReport(
            @RequestBody @Valid ReportDto reportDto) {

        reportService.createReport(reportDto);

        var response = ApiResponse
                .builder()
                .status("success")
                .message("Report was created successfully.")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/routing")
    public ResponseEntity<ApiResponse<List<ReportsDto>>> routing(
            @RequestBody RoutingDto routingDto
            ) throws ParseException {

        var reports = reportService.routing(routingDto);

        var response = ApiResponse
                .<List<ReportsDto>>builder()
                .status("success")
                .data(reports)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/reports/{reportId}/feedback")
    public ResponseEntity<ApiResponse<Object>> feedback(
            @PathVariable long reportId,
            @RequestParam(name = "action") FeedbackAction action
            ) {

        reportService.feedback(reportId, action);

        var response = ApiResponse
                .builder()
                .status("success")
                .message("Your feedback has been successfully submitted.")
                .build();

        return ResponseEntity.ok(response);
    }
}
