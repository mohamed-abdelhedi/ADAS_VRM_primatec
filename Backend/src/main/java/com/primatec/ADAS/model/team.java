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
@Table(name="team")
public class team {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "team_id", columnDefinition = "VARCHAR(40)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @JsonIgnore
    private UUID team_id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "team_Lead_id")
    private user teamLead;




  public Set<resource> getResources() {
       return resources;
  }

   public void setResources(Set<resource> resources) {
       this.resources = resources;
   }

   @OneToMany(mappedBy = "team")
    private Set<resource> resources = new HashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<project> project = new HashSet<>();
    public Set<user> getUsers() {
        return users;
    }

    public void setUsers(Set<user> users) {
        this.users = users;
    }

    @ManyToMany
    @JoinTable(
            name = "user_team",
            joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    )
    private Set<user> users = new HashSet<>();

    public team(Long team_id) {
        this.team_id = UUID.randomUUID();;
    }




    // Getter and Setter
    public team() {

    }
    public void setTeam_id(UUID team_id) {
        this.team_id = UUID.randomUUID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public UUID getTeam_id() {
        return team_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<project> getProject() {
        return project;
    }

    public void setProject(Set<project> project) {
        this.project = project;
    }
    public team(@JsonProperty("team_id") UUID team_id,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description)
    {

        this.team_id = team_id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "team{" +
                "team_id=" + team_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
