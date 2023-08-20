package com.primatec.ADAS.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "user_skill")
public class UserSkill {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_skill_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID user_skill_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private skill skill;

    private int proficiency; // Entity-level attribute

    public UserSkill() {
    }

    public UserSkill(user user, skill skill, int proficiency) {
        this.user = user;
        this.skill = skill;
        this.proficiency = proficiency;
    }

    // Getter and Setter methods

    public UUID getId() {
        return user_skill_id;
    }

    public void setId(UUID id) {
        this.user_skill_id = id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public skill getSkill() {
        return skill;
    }

    public void setSkill(skill skill) {
        this.skill = skill;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
}
