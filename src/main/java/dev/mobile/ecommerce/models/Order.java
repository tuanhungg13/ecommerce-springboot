package dev.mobile.ecommerce.models;

import dev.mobile.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String uid;

    @Column(nullable = false)
    private String customerName; // Địa chỉ giao hàng nhập khi checkout

    @Column(nullable = false)
    private String shippingAddress; // Địa chỉ giao hàng nhập khi checkout

    @Column(nullable = false)
    private String shippingPhoneNumber; // Số điện thoại giao hàng nhập khi checkout

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    private BigDecimal totalAmount;

    private double discount;

    @ManyToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

