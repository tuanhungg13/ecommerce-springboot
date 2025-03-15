package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng
    private Long categoryId;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;
}
