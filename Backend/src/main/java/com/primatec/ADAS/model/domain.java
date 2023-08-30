package com.primatec.ADAS.model;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "domain")
public class domain {
    @Id
    @GeneratedValue(generator = "uuid2")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID domainId;

    private String name;

}
