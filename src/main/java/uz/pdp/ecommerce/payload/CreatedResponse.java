package uz.pdp.ecommerce.payload;

import javax.swing.*;
import java.util.UUID;

public class CreatedResponse {
    private String id;
    private String message;

    public CreatedResponse(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
