package com.primatec.ADAS.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.primatec.ADAS.model.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.UUID;


    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @Table(name = "user_skill")
    public class UserSkill {

        @Id
        @GeneratedValue(generator = "uuid2")
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
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate date;

        private int proficiency;

        public UserSkill(User user, skill skill, LocalDate date, int proficiency) {
            this.user = user;
            this.skill = skill;
            this.date = date;
            this.proficiency = proficiency;
        }
    }

