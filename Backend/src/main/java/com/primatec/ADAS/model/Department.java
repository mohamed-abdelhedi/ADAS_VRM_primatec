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
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "department_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @JsonIgnore
    private UUID department_id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
    @ManyToOne
    @JoinColumn(name = "department_lead_id")
    private user departmentLead;


    @ManyToMany(mappedBy = "departments")
    private Set<group> groups = new HashSet<>();





    @ManyToOne
    @JoinColumn(name = "parent_department_id")
    private Department parentDepartment;

    @OneToMany(mappedBy = "parentDepartment")
    private Set<Department> childDepartments = new HashSet<>();
    public Department() {
    }

    public Department(@JsonProperty("department_id") UUID departmentId,
                      @JsonProperty("name") String name,
                      @JsonProperty("location") String location) {
        this.department_id = department_id;
        this.name = name;
        this.location = location;
    }

    // Getter and Setter methods

    public UUID getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(UUID department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Set<group> getGroups() {
        return groups;
    }

    public void setGroups(Set<group> groups) {
        this.groups = groups;
    }



    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + department_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
