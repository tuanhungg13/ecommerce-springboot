package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Double discount;

    private Double orderedProductPrice;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "variantId", referencedColumnName = "variantId")
    private ProductVariants productVariant;
}


