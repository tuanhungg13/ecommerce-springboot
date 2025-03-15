package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng
    private Long cartId;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false) // Tạo khóa ngoại trỏ đến User
    private User user;
}
