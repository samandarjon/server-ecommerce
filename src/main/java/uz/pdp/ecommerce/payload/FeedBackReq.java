package uz.pdp.ecommerce.payload;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class FeedBackReq {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("message")
    private String message;

    public FeedBackReq(UUID id, String message) {
        this.id = id;
        this.message = message;
    }

    public FeedBackReq(UUID id) {
        this.id = id;
    }

    public FeedBackReq(String message) {
        this.message = message;
    }

    public FeedBackReq() {
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
}
