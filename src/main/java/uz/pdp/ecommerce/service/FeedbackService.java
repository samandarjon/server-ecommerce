package uz.pdp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Feedback;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.FeedbackMessage;
import uz.pdp.ecommerce.repository.FeedbackRepository;
import uz.pdp.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<FeedbackMessage> findProductFeedback(UUID productId) {
        return feedbackRepository.getFeedback(productId);
    }

    public ApiResponse createFeedback(UUID productId, String message) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Mahsyulot topilmadi."));
        Feedback feedback = new Feedback();
        feedback.setMessage(message);
        feedback.setProduct(product);
        feedbackRepository.save(feedback);
        return new ApiResponse("Mahsulot qo`shildi", 201);
    }

    public ApiResponse delete(UUID id) {
        feedbackRepository.deleteById(id);
        return new ApiResponse("Yozishma o`chirildi",200);
    }
}
