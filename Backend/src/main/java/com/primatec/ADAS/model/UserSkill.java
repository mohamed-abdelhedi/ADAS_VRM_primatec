package com.primatec.ADAS.model;

import com.primatec.ADAS.model.User.User;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
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
        private User user;


        @ManyToOne
        @JoinColumn(name = "skill_id")
        private skill skill;


        @Column(name = "date")
        private LocalDate date;

        private int proficiency;

        public UserSkill() {
        }

        public UserSkill(User user, skill skill, LocalDate date, int proficiency) {
            this.user = user;
            this.skill = skill;
            this.date = date;
            this.proficiency = proficiency;
        }
    }

