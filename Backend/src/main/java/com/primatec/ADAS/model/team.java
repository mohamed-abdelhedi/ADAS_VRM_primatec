package com.primatec.ADAS.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.primatec.ADAS.model.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="team")
public class team {
    @Id
    @GeneratedValue(generator = "uuid2")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID team_id;
    private String name;
    private String description;
    private String teamLead;


   @OneToMany(mappedBy = "team")
    private Set<resource> resources = new HashSet<>();

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private Set<project> project = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_team",
            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    )
    @JsonIgnore

    private Set<User> users = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "departments_team",
            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    )
    private Set<Department> Departments = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "group_team",
            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    )
    private Set<group> groups = new HashSet<>();

    @JsonCreator
    public team(@JsonProperty("team_id") UUID team_id) {
        this.team_id = team_id;
    }
}
