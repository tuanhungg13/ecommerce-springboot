package dev.mobile.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productVariants")
public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variantId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "colorId")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "sizeId")
    private Size size;

    private Integer quantity;
}

