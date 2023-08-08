package com.primatec.ADAS.model.workload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.user;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "workload")
public class Workload {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "workload_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @JsonIgnore
    private UUID workloadId;

    @Column(name = "name")
    private String name;

    @Column(name = "domain")
    private String domain;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "workload_state")
    private workloadResult workloadState;

    @Column(name = "percentage")
    private double percentage;

    @ManyToOne
    @JoinColumn(name = "user_id")
   private user assignedUser;

    @ManyToMany
    @JoinTable(
            name = "project_workload",
            joinColumns = @JoinColumn(name = "workload_id", referencedColumnName = "workload_id"),
            inverseJoinColumns = @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    )
    private Set<project> projects = new HashSet<>();

    // Constructors, getters, setters, and other methods...

    public UUID getWorkloadId() {
        return workloadId;
    }

    public void setWorkloadId(UUID workloadId) {
        this.workloadId = workloadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public workloadResult getWorkloadState() {
        return workloadState;
    }

    public void setWorkloadState(workloadResult workloadState) {
        this.workloadState = workloadState;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }




    public Set<project> getProjects() {
        return projects;
    }

    public void setProjects(Set<project> projects) {
        this.projects = projects;
    }
}


