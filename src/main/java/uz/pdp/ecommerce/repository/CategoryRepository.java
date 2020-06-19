package uz.pdp.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommerce.entity.Category;
import uz.pdp.ecommerce.projection.CategoryProjection;

@RepositoryRestResource(path = "categories", excerptProjection = CategoryProjection.class)
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
