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
    public ResponseEntity<?> getAllProduct(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "user", defaultValue = "") UUID user) {
        return ResponseEntity.ok(productService.getAll(page, user));
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getAllProductByCategory(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "category", defaultValue = "all") String category) {
        return ResponseEntity.ok(productService.getAllProductByCategory(page, category));
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

    @PostMapping("/{categoryId}")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto, @PathVariable Long categoryId) {
        Product add = productService.add(productDto, categoryId);
        return ResponseEntity.ok(add);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        ApiResponse delete = productService.delete(id);
        return ResponseEntity.ok(delete);
    }
}
