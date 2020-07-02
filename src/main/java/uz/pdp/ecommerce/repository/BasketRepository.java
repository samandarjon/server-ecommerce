package uz.pdp.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Basket;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.UUID;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findAllByUserIdOrderByIdDesc(UUID userId);
}
