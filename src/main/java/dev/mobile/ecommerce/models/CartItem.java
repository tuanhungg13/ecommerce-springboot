package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cartItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng
    private Long cartItemId;

    private Double discount;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "cartId", nullable = false) // Liên kết với Cart
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "variantId", nullable = false) // Liên kết với ProductVariant
    private ProductVariants productVariant;
}
