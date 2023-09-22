package com.neshan.reportservice.controllers;

import com.neshan.reportservice.model.ApiResponse;
import com.neshan.reportservice.model.dto.*;
import com.neshan.reportservice.model.dto.report.ReportDto;
import com.neshan.reportservice.model.entity.User;
import com.neshan.reportservice.model.enums.ApprovalAction;
import com.neshan.reportservice.model.enums.FeedbackAction;
import com.neshan.reportservice.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.io.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/reports")
    public ResponseEntity<ApiResponse<List<GetAllReportsDto>>> getAllReports() {

        var reports = reportService.getAllReports();

        var response = ApiResponse
                .<List<GetAllReportsDto>>builder()
                .status("success")
                .data(reports)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/reports/{reportId}")
    public ResponseEntity<ApiResponse<GetReportDto>> getReport(
            @PathVariable long reportId) {

        var report = reportService.getReport(reportId);

        var response = ApiResponse
                .<GetReportDto>builder()
                .status("success")
                .data(report)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/my-reports")
    public ResponseEntity<ApiResponse<List<GetAllReportsOfUserDto>>> getAllReportsOfUser(
            @AuthenticationPrincipal User user) {

        var reports = reportService.getAllReportsOfUser(user);

        var response = ApiResponse
                .<List<GetAllReportsOfUserDto>>builder()
                .status("success")
                .data(reports)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/reports")
    public ResponseEntity<ApiResponse<Object>> createReport(
            @RequestBody @Valid ReportDto reportDto,
            @AuthenticationPrincipal User user) {

        reportService.createReport(reportDto, user);

        var response = ApiResponse
                .builder()
                .status("success")
                .message("Report was created successfully.")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<ApiResponse<Object>> deleteReport(
            @PathVariable long reportId) {

        reportService.deleteReport(reportId);

        var response = ApiResponse
                .builder()
                .status("success")
                .message("Report was deleted successfully.")
                .build();

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/reports")
    public ResponseEntity<ApiResponse<Object>> deleteAllReports() {
        reportService.deleteAllReports();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/routing")
    public ResponseEntity<ApiResponse<List<RouteReports>>> routing(
            @RequestBody RoutingDto routingDto
    ) throws ParseException {

        var reports = reportService.routing(routingDto);

        var response = ApiResponse
                .<List<RouteReports>>builder()
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

    @GetMapping("/approval-reports")
    public ResponseEntity<ApiResponse<List<ApprovalReports>>> getApprovalNeedReports() {

        var approvalNeedReports = reportService.getApprovalNeedReports();

        var response = ApiResponse
                .<List<ApprovalReports>>builder()
                .status("success")
                .data(approvalNeedReports)
                .build();

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/approval-reports/{reportId}")
    public ResponseEntity<ApiResponse<Object>> approveReport(
            @PathVariable long reportId,
            @RequestParam(name = "action") ApprovalAction action) {

        reportService.approveReport(reportId, action);

        var response = ApiResponse
                .builder()
                .status("success")
                .message("Report was approved successfully.")
                .build();

        return ResponseEntity.ok(response);
    }
}
