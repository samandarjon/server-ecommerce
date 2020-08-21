package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.repository.UserRepository;
import uz.pdp.ecommerce.security.CurrentUser;

@RestController("/api/users/me")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<User> getUser(@CurrentUser User user) {
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteUser(@CurrentUser User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(new ApiResponse());
    }
}
