package com.primatec.ADAS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "custom_group")
public class group {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "group_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @JsonIgnore
    private UUID groupId;

    @Column(name = "name")
    private String name;

    @Column(name = "domain")
    private String domain;
    @ManyToOne
    @JoinColumn(name = "group_Lead_id")
    private user groupLead;
    @ManyToMany
    @JoinTable(
            name = "group_team",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    )
    private Set<team> teams = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "group_user",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    )
    private Set<user> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "group_department",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    )
    private Set<Department> departments = new HashSet<>();

    public group() {
    }

    public group(@JsonProperty("group_id") UUID groupId,
                 @JsonProperty("name") String name,
                 @JsonProperty("domain") String domain) {
        this.groupId = groupId;
        this.name = name;
        this.domain = domain;
    }

    // Getter and Setter methods

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
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

    public Set<team> getTeams() {
        return teams;
    }

    public void setTeams(Set<team> teams) {
        this.teams = teams;
    }

    public Set<user> getUsers() {
        return users;
    }

    public void setUsers(Set<user> users) {
        this.users = users;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public user getGroupLead() {
        return groupLead;
    }

    public void setGroupLead(user groupLead) {
        this.groupLead = groupLead;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
