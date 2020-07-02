package uz.pdp.ecommerce.utils.convertors;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.payload.ProductDto;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductConverter {
    ProductDto productToProductDto(Product product);

    List<ProductDto> productListToProductDtos(List<Product> products);
}
