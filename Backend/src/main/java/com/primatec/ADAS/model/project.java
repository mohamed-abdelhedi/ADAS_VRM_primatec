package com.primatec.ADAS.model;

import com.primatec.ADAS.model.test.test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class project {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "projectId", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID projectId;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "projectDescription")
    private String projectDescription; // New field for project description

    @ManyToOne // Many projects can be assigned to one team
    @JoinColumn(name = "team_id")
    private team team;



    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("project")
    private Set<test> tests = new HashSet<>();

    // Constructors, getters, and setters

    public project(@JsonProperty("projectId") UUID projectId,
                   @JsonProperty("projectName") String projectName,
                   @JsonProperty("startDate") LocalDate startDate,
                   @JsonProperty("deadline") LocalDate deadline,
                   @JsonProperty("projectDescription") String projectDescription) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.deadline = deadline;
        this.projectDescription = projectDescription;
    }

    public project() {}

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public team getTeam() {
        return team;
    }

    public void setTeam(team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", deadline=" + deadline +
                ", projectDescription='" + projectDescription + '\'' +
                '}';
    }

    public Set<test> getTests() {
        return tests;
    }

    public void setTests(Set<test> tests) {
        this.tests = tests;
    }
}
