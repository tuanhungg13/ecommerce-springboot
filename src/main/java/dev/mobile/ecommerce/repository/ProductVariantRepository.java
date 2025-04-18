package dev.mobile.ecommerce.repository;

import dev.mobile.ecommerce.models.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariants, Long> {
    // Các phương thức truy vấn tùy chỉnh (nếu có)
}

