package com.primatec.ADAS.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="resource")
public class resource {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "resource_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID resource_id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="numberOfUsage")
    private int numberOfUsage;
    @Column(name="dateOfPurchasing")
    private Date dateOfPurchasing;
    @Column(name="reference")
    private String reference;
    @Column(name="availability")
    private boolean availability;

    @Column(name="other_info")
    private String other_info;

    public resource() {

    }

    public UUID getResource_id() {
        return resource_id;
    }

    public void setResource_id(UUID resource_id) {
        this.resource_id = resource_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfUsage() {
        return numberOfUsage;
    }

    public void setNumberOfUsage(int numberOfUsage) {
        this.numberOfUsage = numberOfUsage;
    }

    public Date getDateOfPurchasing() {
        return dateOfPurchasing;
    }

    public void setDateOfPurchasing(Date dateOfPurchasing) {
        this.dateOfPurchasing = dateOfPurchasing;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }
    public resource(@JsonProperty("resource_id") UUID resource_id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("numberOfUsage") int numberOfUsage,
                @JsonProperty("dateOfPurchasing") Date dateOfPurchasing,
                @JsonProperty("reference") String reference,
                @JsonProperty("availability") boolean availability,
                @JsonProperty("other_info") String other_info)
    {
        this.resource_id = resource_id;
        this.name = name;
        this.description = description;
        this.numberOfUsage = numberOfUsage;
        this.dateOfPurchasing = dateOfPurchasing;
        this.reference = reference;
        this.availability = availability;
        this.other_info = other_info;
    }

    @Override
    public String toString() {
        return "resource{" +
                "resource_id=" + resource_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOfUsage=" + numberOfUsage +
                ", dateOfPurchasing=" + dateOfPurchasing +
                ", reference='" + reference + '\'' +
                ", availability=" + availability +
                ", other_info='" + other_info + '\'' +
                '}';
    }


    @ManyToOne
    @JoinColumn(name = "team_id")
    private team team;

    public team getTeam() {
        return team;
    }

    public void setTeam(team team) {
        this.team = team;
    }


}
