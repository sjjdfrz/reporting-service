package com.neshan.reportservice.model.dto;


import com.neshan.reportservice.model.dto.user.UsersDto;

public record GetReportDto(

        String location,
        UsersDto user
) {
}
