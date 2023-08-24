package com.primatec.ADAS.model;

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
@Table(name = "custom_group")
public class group {

    @Id
    @GeneratedValue(generator = "uuid2")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID group_id;
    private String name;
    private String domain;
    private String groupLead;


    @ManyToMany
    @JoinTable(
            name = "group_department",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    )
    private Set<Department> departments = new HashSet<>();



}
