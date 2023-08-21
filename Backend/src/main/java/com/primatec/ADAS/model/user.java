package com.primatec.ADAS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.primatec.ADAS.model.workload.Workload;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.*;

@Entity
@Table(name = "users")

public class user {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)

    private UUID user_id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "experience")
    private String experience;

    @Column(name = "join_date")
    private Date joinDate;
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;
    @Column(name = "imgLink")
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


    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public user() {
    }

    public String getPhone_number() {
        return phone_number;
    }

    @Column(name = "phone_number")
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


    public Date getJoinDate() {
        return joinDate;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }


    public String getImgLink() {
        return imgLink;
    }

    public user(@JsonProperty("user_id") UUID user_id,
                @JsonProperty("name") String name,
                @JsonProperty("username") String username,
                @JsonProperty("birthdate") Date birthdate,
                @JsonProperty("experience") String experience,
                @JsonProperty("joinDate") Date joinDate,
                @JsonProperty("email") String email,
                @JsonProperty("description") String description,
                @JsonProperty("imgLink") String imgLink,
                @JsonProperty("phone_number") String phone_number) {
        this.user_id = user_id;
        this.username = username;
        this.name = name;
        this.birthdate = birthdate;
        this.experience = experience;
        this.joinDate = joinDate;
        this.email = email;
        this.description = description;
        this.imgLink = imgLink;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", birthdate=" + birthdate +
                ", experience='" + experience + '\'' +
                ", joinDate=" + joinDate +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", teams=" + teams +
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

    @OneToMany(mappedBy = "user")
    private Set<UserSkill> userSkills = new HashSet<>();


    public Set<Department> getDepartments() {
        return Departments;
    }

    public void setDepartments(Set<Department> departments) {
        Departments = departments;
    }

    @ManyToMany
    @JoinTable(
            name = "departments_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    )
    private Set<Department> Departments = new HashSet<>();

    public Set<group> getGroups() {
        return groups;
    }

    public void setGroups(Set<group> groups) {
        this.groups = groups;
    }

    @ManyToMany
    @JoinTable(
            name = "group_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    )
    private Set<group> groups = new HashSet<>();
}
