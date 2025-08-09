package com.ajunquit.kvmd_api.domain.auth.entity;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ajunquit.kvmd_api.domain.auth.enums.EnumRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID id;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, unique = true)
    private String userName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(max = 120)
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Size(max = 120)
    private String fullName;

    private Set<EnumRoles> roles;

    @Column(nullable = false)
    private boolean activeRecord;

    @CreationTimestamp
    @Column(nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = true)
    private Instant updatedAt;

}
