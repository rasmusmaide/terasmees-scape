package com.example.demo.entities;


import com.example.demo.entities.enums.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@Table(name = "forum_user")
@Entity
public class ForumUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username", unique = true)
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserRole role;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}