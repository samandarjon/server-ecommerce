package uz.pdp.ecommerce.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;


public class LoginUser {
    @NotBlank(message = "Username bo`sh bo`lishi mumkin emas.")
    private String username;
    @NotBlank(message = "Parol bo`sh bo`lishi mumkin emas.")
    private String password;

    public LoginUser(@NotBlank(message = "Username bo`sh bo`lishi mumkin emas.") String username, @NotBlank(message = "Parol bo`sh bo`lishi mumkin emas.") String password) {
        this.username = username;
        this.password = password;
    }

    public LoginUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
