package com.primatec.ADAS.model.workload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.model.skill;
import com.primatec.ADAS.model.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "workload")
public class Workload {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "workload_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID workloadId;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    private Date deadLine;

    @Column(name = "workload_state")
    private workloadResult workloadState;
    @Column(name = "description")
    private String description;

    @Column(name = "percentage")
    private double percentage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;


    private String domain;

    @ManyToMany
    @JoinTable(
            name = "project_workload",
            joinColumns = @JoinColumn(name = "workload_id", referencedColumnName = "workload_id"),
            inverseJoinColumns = @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    )
    private Set<project> projects = new HashSet<>();

    @ManyToMany
    private Set<skill> skills = new HashSet<>();

}


