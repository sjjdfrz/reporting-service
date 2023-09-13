package com.neshan.reportservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reports")
@SQLDelete(sql = "UPDATE reports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Report {

    @Id
    @SequenceGenerator(
            name = "report_sequence",
            sequenceName = "report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "report_sequence"
    )
    private long id;

    private Point location;

    @Builder.Default
    private boolean deleted = false;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;
}
