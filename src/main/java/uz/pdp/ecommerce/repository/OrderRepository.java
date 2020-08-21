package uz.pdp.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Page<Order> findByCreatedBy(UUID createdBy, Pageable pageable);
    Page<Order> findByProductCreatedByOrderByCreatedAt(UUID product_createdBy, Pageable pageable);
}
