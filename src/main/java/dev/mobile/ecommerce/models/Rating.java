package dev.mobile.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ratingProduct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user; // Người dùng đánh giá

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product; // Sản phẩm được đánh giá

    @Column(nullable = false)
    private Integer rating; // Điểm đánh giá (1-5)

    @Column(columnDefinition = "TEXT")
    private String comment; // Nội dung đánh giá

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now(); // Thời gian tạo đánh giá
}
