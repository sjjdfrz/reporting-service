package com.neshan.reportservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neshan.reportservice.dto.MockGetAllReportsDto;
import com.neshan.reportservice.dto.MockRouteReports;
import com.neshan.reportservice.model.Point;
import com.neshan.reportservice.model.dto.CreateReportDto;
import com.neshan.reportservice.model.dto.GetAllReportsDto;
import com.neshan.reportservice.model.dto.RouteReports;
import com.neshan.reportservice.model.dto.RoutingDto;
import com.neshan.reportservice.model.enums.ApprovalAction;
import com.neshan.reportservice.model.enums.FeedbackAction;
import com.neshan.reportservice.model.enums.ReportTitle;
import com.neshan.reportservice.model.enums.ReportType;
import com.neshan.reportservice.security.JwtService;
import com.neshan.reportservice.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ReportController.class)
@AutoConfigureMockMvc(addFilters = false)
class ReportControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Autowired
    public ReportControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @MockBean
    private ReportService reportService;

    @MockBean
    private JwtService jwtService;

    @Test
    void getAllReports() throws Exception {

        List<GetAllReportsDto> reports = List.of(
                new MockGetAllReportsDto(1, "accident", ReportType.LIGHT),
                new MockGetAllReportsDto(2, "police", ReportType.SECRET_POLICE)
        );

        when(reportService.getAllReports()).thenReturn(reports);

        mockMvc.perform(get("/reports")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].id", is(1)))
                .andExpect(jsonPath("$.data[0].title", is("accident")))
                .andExpect(jsonPath("$.data[0].type", is(ReportType.LIGHT.name())))
                .andExpect(jsonPath("$.data[1].id", is(2)))
                .andExpect(jsonPath("$.data[1].title", is("police")))
                .andExpect(jsonPath("$.data[1].type", is(ReportType.SECRET_POLICE.name())));
    }

    @Test
    void createReport() throws Exception {

        Point point = new Point(51.43767714500427, 35.71753998427532);
        CreateReportDto createReportDto = new CreateReportDto(
                point, ReportTitle.ACCIDENT, ReportType.LIGHT);

        mockMvc.perform(post("/reports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createReportDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath(
                        "$.message",
                        is("Report was created successfully.")));
    }

    @Test
    void deleteReport() throws Exception {

        long reportId = 1L;

        mockMvc.perform(delete("/reports/{reportId}", reportId))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath(
                        "$.message",
                        is("Report was deleted successfully.")));
    }

    @Test
    void feedback() throws Exception {

        long reportId = 1L;
        FeedbackAction action = FeedbackAction.LIKE;

        mockMvc.perform(post("/reports/{reportId}/feedback", reportId)
                        .param("action", action.name()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath(
                        "$.message",
                        is("Your feedback has been successfully submitted.")));
    }

    @Test
    void routing() throws Exception {

        RoutingDto routingDto = new RoutingDto("""
                LINESTRING(51.4378 35.71678,51.43772 35.71681,51.43803 35.7174,51.43766
                35.71753,51.43767 35.71755,51.43798 35.71821,51.43792 35.71823)
                """);

        List<RouteReports> reports = List.of(
                new MockRouteReports("POINT (1 2)", "accident", ReportType.LIGHT),
                new MockRouteReports("POINT (2 4)", "traffic", ReportType.HEAVY)
        );

        when(reportService.routing(routingDto)).thenReturn(reports);

        mockMvc.perform(post("/routing")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(routingDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.data[0].location", is("POINT (1 2)")))
                .andExpect(jsonPath("$.data[1].location", is("POINT (2 4)")));
    }

    @Test
    void approveReport() throws Exception {

        long reportId = 1L;
        ApprovalAction action = ApprovalAction.APPROVE;

        mockMvc.perform(patch("/approval-reports/{reportId}", reportId)
                        .param("action", action.name()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("success")))
                .andExpect(jsonPath(
                        "$.message",
                        is("Report was approved successfully.")));
    }
}
