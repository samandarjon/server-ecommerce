package uz.pdp.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Page<Product> findAllByCreatedBy(UUID createdBy, Pageable pageable);

    Page<Product> findAllByCategoryName(String category_name, Pageable pageable);

}
