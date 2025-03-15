package dev.mobile.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;

    private String colorName;
}

