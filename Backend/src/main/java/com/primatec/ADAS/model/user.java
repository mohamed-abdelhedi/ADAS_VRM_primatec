package com.primatec.ADAS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.primatec.ADAS.model.test.test;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.*;

@Entity
@Table(name="users")

public class user {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)

    private UUID user_id;
    @Column(name="name")
    private String name;
    @Column(name="birthdate")
    private Date birthdate;
    @Column(name="experience")
    private String experience;
    @Column(name="domain")
    private String domain;
    @Column(name="department")
    private String department;
    @Column(name="join_date")
    private Date joinDate;
    @Column(name="email")
    private String email;
    @Column(name="description")
    private String description;
    @Column(name="tools")
    private String tools;
    @Column(name="technologies")
    private String technologies;
    @Column(name="imgLink")
    private String imgLink;



    // Getter and setter
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }




    public user() {}

    public String getPhone_number() {
        return phone_number;
    }

    @Column(name="phone_number")
    private String phone_number;

    public void setId(UUID user_id) {
        this.user_id = user_id;
    }
    public UUID getUser_id() {
        return user_id;
    }
    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getExperience() {
        return experience;
    }

    public String getDomain() {
        return domain;
    }

    public String getDepartment() {
        return department;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getTools() {
        return tools;
    }

    public String getTechnologies() {
        return technologies;
    }

    public String getImgLink() {
        return imgLink;
    }

    public user(@JsonProperty("user_id") UUID user_id,
                @JsonProperty("name") String name,
                @JsonProperty("birthdate") Date birthdate,
                @JsonProperty("experience") String experience,
                @JsonProperty("domain") String domain,
                @JsonProperty("department") String department,
                @JsonProperty("joinDate") Date joinDate,
                @JsonProperty("email") String email,
                @JsonProperty("description") String description,
                @JsonProperty("tools") String tools,
                @JsonProperty("technologies") String technologies,
                @JsonProperty("imgLink") String imgLink,
                @JsonProperty("phone_number") String phone_number)
    {
        this.user_id = user_id;
        this.name = name;
        this.birthdate = birthdate;
        this.experience = experience;
        this.domain = domain;
        this.department = department;
        this.joinDate = joinDate;
        this.email = email;
        this.description = description;
        this.tools = tools;
        this.technologies = technologies;
        this.imgLink = imgLink;
        this.phone_number=phone_number;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + user_id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", experience='" + experience + '\'' +
                ", domain='" + domain + '\'' +
                ", department='" + department + '\'' +
                ", joinDate=" + joinDate +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", tools='" + tools + '\'' +
                ", technologies='" + technologies + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }


    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<team> teams = new HashSet<>();

    public Set<team> getTeams() {
        return teams;
    }

    public void setTeams(Set<team> teams) {
        this.teams = teams;
    }

    @OneToMany(mappedBy = "tester")
    @JsonIgnore
    private List<test> tests;
    public List<test> getTests() {
        return tests;
    }

    public void setTests(List<test> tests) {
        this.tests = tests;
    }
}
