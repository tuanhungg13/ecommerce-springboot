package dev.mobile.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;

    private String sizeName;
}

