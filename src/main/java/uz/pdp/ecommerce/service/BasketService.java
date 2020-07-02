package uz.pdp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Basket;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.exceprions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.BasketDto;
import uz.pdp.ecommerce.repository.BasketRepository;
import uz.pdp.ecommerce.repository.ProductRepository;
import uz.pdp.ecommerce.utils.convertors.BasketConverter;

import java.util.List;
import java.util.UUID;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BasketConverter basketConverter;

    public List<BasketDto> findUserBasketItem(UUID id) {
        List<Basket> allByUserIdOrderByIdDesc = basketRepository.findAllByUserIdOrderByIdDesc(id);
        return basketConverter.BasketListToBasketDto(allByUserIdOrderByIdDesc);

    }

    public ApiResponse addBasket(User user, UUID productId) {
        Basket basket = new Basket();
        basket.setUserId(user.getId());
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Bunday mahsulot topilmadi."));
        basket.setProduct(product);
        productRepository.save(product);
        return new ApiResponse("Mahuslot savatga qo`shildi.", 201);

    }

    public ApiResponse delete(Long id) {
        basketRepository.deleteById(id);
        return new ApiResponse("Savatdan mahsulot o`chirildi.", 200);

    }
}
