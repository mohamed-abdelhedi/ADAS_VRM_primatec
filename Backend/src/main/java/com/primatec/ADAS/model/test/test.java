package com.primatec.ADAS.model.test;

import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.user;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Entity
public class test {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "testId", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID testId;

    private String testName;
    private LocalDate testDate;


    private int testpriority;
    @Enumerated(EnumType.STRING)
    private testResult  testResult;

    // Many tests can be associated with one tester
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user tester;

    // Many tests can be associated with one project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private com.primatec.ADAS.model.project project;

    public test() {

    }

    public UUID getTestId() {
        return testId;
    }

    public void setTestId(UUID testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public testResult getTestResult() {
        return testResult;
    }

    public void setTestResult(testResult testResult) {
        this.testResult = testResult;
    }
    public int getTestpriority() {
        return testpriority;
    }

    public void setTestpriority(int testpriority) {
        this.testpriority = testpriority;
    }


    public user getTester() {
        return tester;
    }

    public void setTester(user tester) {
        this.tester = tester;
    }

    public project getProject() {
        return project;
    }

    public void setProject(project project ) {
        this.project = project;
    }

    public test(@JsonProperty("testId") UUID testId,
                @JsonProperty("testName") String testName,
                @JsonProperty("testDate") LocalDate testDate,
                @JsonProperty("testResult") testResult testResult,
                @JsonProperty("testpriority") int testpriority) {
        this.testId = testId;
        this.testName = testName;
        this.testDate = testDate;
        this.testResult = testResult;
        this.testpriority=testpriority;

    }
}
