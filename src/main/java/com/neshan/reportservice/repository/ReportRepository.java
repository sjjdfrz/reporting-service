package com.neshan.reportservice.repository;

import com.neshan.reportservice.model.dto.*;
import com.neshan.reportservice.model.entity.Report;
import com.neshan.reportservice.model.enums.ApprovalAction;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {


    @Query(value = """
            select
            id, title, type,
            ST_AsText(location) as location,
            TO_CHAR(created_at, 'YYYY-MM-DD HH:MI:SS') as date
            from reports
            where user_id = :userId
            """, nativeQuery = true)
    List<GetAllReportsOfUserDto> findAllReportsByUserId(@Param("userId") long userId);

    @Query(value = """
            select id, title, type
            from reports
            """, nativeQuery = true)
    List<GetAllReportsDto> findAllReports();

    @Modifying
    @Query(value = """
            update reports
            set approved =
            case
                when :action = 'APPROVE' then true
                when :action = 'REJECT' then false
            end
            where id = :reportId
            """, nativeQuery = true)
    void approveReport(
            @Param("reportId") long reportId,
            @Param("action") String action);

    @Query(value = """
            select id, title, type, ST_AsText(location) as location
            from reports
            where approved = false
            """, nativeQuery = true)
    List<ApprovalReports> findAllApprovedNeedReports();

    @Query(value = """
            select title, type, ST_AsText(location) as location
            from reports
            where
            ST_DWithin(ST_Transform(location, 3857), ST_Transform(:routeLine, 3857), 10) and
            current_timestamp < expires_at and
            (approved = true or approved IS null)
            """, nativeQuery = true)
    List<RouteReports> findAllReportsOfRoute(@Param("routeLine") LineString routeLine);

    @Query(value = """
            select case when count(*) > 0 then true else false end
            from reports
            where
            location = :location and
            type = :type and
            extract(minute from current_timestamp - created_at) < :timeDifference
            """, nativeQuery = true)
    boolean existsDuplicateReport(
            @Param("location") Point location,
            @Param("type") int type,
            @Param("timeDifference") int timeDifference);
}
