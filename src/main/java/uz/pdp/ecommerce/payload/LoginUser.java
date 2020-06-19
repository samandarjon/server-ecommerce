package uz.pdp.ecommerce.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUser {
    @NotBlank(message = "Username bo`sh bo`lishi mumkin emas.")
    private String username;
    @NotBlank(message = "Parol bo`sh bo`lishi mumkin emas.")
    private String password;
}
