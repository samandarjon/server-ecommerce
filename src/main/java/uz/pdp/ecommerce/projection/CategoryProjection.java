package uz.pdp.ecommerce.projection;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = CategoryProjection.class)
public interface CategoryProjection {
    String getName();

    Long getId();
}
