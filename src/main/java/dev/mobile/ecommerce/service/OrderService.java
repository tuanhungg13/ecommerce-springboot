package dev.mobile.ecommerce.service;

import dev.mobile.ecommerce.models.Order;
import dev.mobile.ecommerce.repository.OrderItemRepository;
import dev.mobile.ecommerce.repository.OrderRepository;
import dev.mobile.ecommerce.repository.ProductVariantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductVariantRepository productVariantRepository;
}

