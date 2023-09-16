package com.neshan.reportservice.repository;

import com.neshan.reportservice.model.dto.ReportsDto;
import com.neshan.reportservice.model.entity.Report;
import com.neshan.reportservice.model.enums.ReportType;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = """
            select ST_AsText(location) as location, title, type
            from reports
            where ST_DWithin(location, :routeLine, 10) and current_timestamp < expires_at
            """, nativeQuery = true)
    List<ReportsDto> findAllReportsOfRoute(@Param("routeLine") LineString routeLine);

    @Query(value = """
            select case when count(*) > 0 then true else false end
            from reports
            where
            location = :location and
            type = :type and
            extract(minute from current_timestamp - created_at) > :timeDifference
            """, nativeQuery = true)
    boolean existsDuplicateReport(
            @Param("location") Point location,
            @Param("type") int type,
            @Param("timeDifference") int timeDifference);
}
