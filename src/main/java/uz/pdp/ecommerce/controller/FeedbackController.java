package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.entity.Feedback;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.CreatedResponse;
import uz.pdp.ecommerce.payload.FeedbackMessage;
import uz.pdp.ecommerce.security.CurrentUser;
import uz.pdp.ecommerce.service.FeedbackService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<?> getAllFeedbackOfProduct(@RequestParam(defaultValue = "productId") UUID productId) {
        List<FeedbackMessage> productFeedback = feedbackService.findProductFeedback(productId);
        return ResponseEntity.ok(productFeedback);
    }

    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody CreatedResponse feedback) {
        ApiResponse response = feedbackService.createFeedback(UUID.fromString(feedback.getId()), feedback.getMessage());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        ApiResponse delete = feedbackService.delete(id);
        return ResponseEntity.status(delete.getStatus()).body(delete);
    }
}
