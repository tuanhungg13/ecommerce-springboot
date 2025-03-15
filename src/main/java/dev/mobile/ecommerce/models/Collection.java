package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "collections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng
    private Long collectionId;

    @Column(nullable = false, unique = true)
    private String name;
}
