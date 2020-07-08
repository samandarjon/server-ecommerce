package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.ProductDto;
import uz.pdp.ecommerce.security.CurrentUser;
import uz.pdp.ecommerce.service.ProductService;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProduct(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam("user") UUID user) {
        return ResponseEntity.ok(productService.getAll(page, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getOne(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @PathVariable UUID id, @CurrentUser User
            user) {
        Product update = productService.update(productDto, id, user.getId());
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        ApiResponse delete = productService.delete(id);
        return ResponseEntity.ok(delete);
    }
}
