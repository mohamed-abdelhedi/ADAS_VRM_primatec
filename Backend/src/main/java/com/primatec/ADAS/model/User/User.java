package com.primatec.ADAS.model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.primatec.ADAS.model.Department;
import com.primatec.ADAS.model.UserSkill;
import com.primatec.ADAS.model.group;
import com.primatec.ADAS.model.team;
import com.primatec.ADAS.security.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid2")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID user_id;

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Date birthdate;
    private String experience;
    private Date joinDate;
    private String email;
    private String description;
    private String imgLink;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phone_number;



    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<team> teams = new HashSet<>();


    @OneToMany(mappedBy = "user")
    private Set<UserSkill> userSkills = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "departments_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    )
    @JsonIgnore
    private Set<Department> Departments = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "group_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    )
    @JsonIgnore
    private Set<group> groups = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Token> tokens;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
