package uz.pdp.ecommerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;


public class TokenResponse {
    private String token;
    private boolean success;

    public TokenResponse(String token, boolean success) {
        this.token = token;
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
