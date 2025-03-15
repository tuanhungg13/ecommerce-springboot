package dev.mobile.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productImages")
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private String imageUrl;
}

