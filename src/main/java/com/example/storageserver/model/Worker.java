package com.example.storageserver.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Worker implements UserDetails {

    @Id
    private Long id;

    @NotBlank(message = "Cannot be empty")
    private String name;

    @NotBlank(message = "Cannot be empty")
    private String surname;

    @NotBlank(message = "Cannot be empty")
    private String patronymic;

    @NotBlank(message = "Cannot be empty")
    @Size(min = 13, max = 13)
    private String phone;

    @NotBlank(message = "Cannot be empty")
    @Email
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @OneToMany(mappedBy = "worker")
    @JsonIgnore
    private List<Arrival> arrivals;

    @OneToMany(mappedBy = "worker")
    @JsonIgnore
    private List<Issuance> issuances;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "worker_position",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set<Position> positions = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();

        this.positions.forEach(position -> {
            authorities.add(new Authority(position.getPosition()));
        });

        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}