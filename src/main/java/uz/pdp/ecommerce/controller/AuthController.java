package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.CreateUserDto;
import uz.pdp.ecommerce.payload.LoginUser;
import uz.pdp.ecommerce.payload.TokenResponse;
import uz.pdp.ecommerce.service.auth.AuthService;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginUser loginUser) {
        TokenResponse tokenResponse = authService.loginUser(loginUser);
        return ResponseEntity.ok(tokenResponse);

    }


}
