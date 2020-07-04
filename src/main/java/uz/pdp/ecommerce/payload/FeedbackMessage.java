package uz.pdp.ecommerce.payload;

import java.util.UUID;

public class FeedbackMessage {
    private UUID id;
    private String message;
    private String user;

    public FeedbackMessage() {
    }

    public FeedbackMessage(UUID id, String message, String user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}


