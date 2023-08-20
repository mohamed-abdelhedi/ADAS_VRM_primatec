package com.primatec.ADAS.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "skill")
public class skill {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "skill_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID skill_id;

    private String name;

    // Getter and Setter methods

    public UUID getId() {
        return skill_id;
    }

    public void setId(UUID id) {
        this.skill_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + skill_id +
                ", name='" + name + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "skill")
    private Set<UserSkill> userSkills = new HashSet<>();
}
