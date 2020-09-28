package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.CreateUserDto;
import uz.pdp.ecommerce.payload.LoginUser;
import uz.pdp.ecommerce.payload.TokenResponse;
import uz.pdp.ecommerce.service.auth.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody CreateUserDto createUserDto) {
        ApiResponse user = authService.createUser(createUserDto);
        return ResponseEntity.status(user.getStatus()).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUser(@Valid @RequestBody LoginUser loginUser) {
        TokenResponse tokenResponse = authService.loginUser(loginUser);
        return ResponseEntity.ok(tokenResponse);

    }


}
