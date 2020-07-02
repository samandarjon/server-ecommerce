package uz.pdp.ecommerce.utils.convertors;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.ecommerce.entity.Basket;
import uz.pdp.ecommerce.payload.BasketDto;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BasketConverter {
    List<BasketDto> BasketListToBasketDto(List<Basket> baskets);

    BasketDto BasketToBasketDto(Basket basket);

}
