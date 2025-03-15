package dev.mobile.ecommerce.models;

import dev.mobile.ecommerce.enums.DiscountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String code; // Mã giảm giá

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal discount; // Số tiền hoặc % giảm

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType type; // Loại giảm giá (PERCENT/FIXED)

    @Column(name = "min_order", precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal minOrder = BigDecimal.ZERO; // Giá trị đơn hàng tối thiểu

    @Column(columnDefinition = "INT DEFAULT 1")
    private Integer quantity = 1; // Số lần sử dụng tối đa

    private LocalDate expirationDate; // Ngày hết hạn

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now(); // Ngày tạo
}