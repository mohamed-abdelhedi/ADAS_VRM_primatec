package com.primatec.ADAS.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSkillRequest {
    private UUID userId;
    private UUID skillId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private int proficiency;

    // Getters and setters
}