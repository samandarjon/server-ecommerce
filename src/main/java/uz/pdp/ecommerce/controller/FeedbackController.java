package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.FeedBackReq;
import uz.pdp.ecommerce.payload.FeedbackMessage;
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
    public ResponseEntity<?> addFeedback(@RequestBody FeedBackReq feedback) {
        System.out.println(feedback.getId());
        System.out.println(feedback.getMessage());
        ApiResponse response = feedbackService.createFeedback(feedback.getId(), feedback.getMessage());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        ApiResponse delete = feedbackService.delete(id);
        return ResponseEntity.status(delete.getStatus()).body(delete);
    }
}
