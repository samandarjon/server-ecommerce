package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.BasketDto;
import uz.pdp.ecommerce.payload.ProductId;
import uz.pdp.ecommerce.security.CurrentUser;
import uz.pdp.ecommerce.service.BasketService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @GetMapping
    public ResponseEntity<?> getAllBasketItem(@CurrentUser User user) {
        List<BasketDto> userBasketItem = basketService.findUserBasketItem(user.getId());
        return ResponseEntity.ok(userBasketItem);
    }

    @PostMapping
    public ResponseEntity<?> addItemForBasket(@CurrentUser User user, @Valid @RequestBody ProductId productId) {
        UUID id;
        try {
            id = UUID.fromString(productId.getProductId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException("Bunday mahsulot topilmadi");
        }
        List<BasketDto> basketDtos = basketService.addBasket(user, id);
        return ResponseEntity.ok(basketDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItemFromBasket(@PathVariable Long id) {
        ApiResponse delete = basketService.delete(id);
        return ResponseEntity.status(delete.getStatus()).body(delete);
    }
}
