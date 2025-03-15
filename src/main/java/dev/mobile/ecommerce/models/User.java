package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Tự động tạo UUID
    @Column(nullable = false, updatable = false)
    private String uid;

    @Column(unique = true, nullable = false)
    private String email;

    private String avatar;
    private Integer role;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String accessToken;
    private String refreshToken;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt = LocalDate.now();
}

