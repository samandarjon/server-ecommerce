package uz.pdp.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.pdp.ecommerce.entity.Category;
import uz.pdp.ecommerce.projection.CategoryProjection;

@CrossOrigin
@RepositoryRestResource(path = "categories", excerptProjection = CategoryProjection.class)
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
