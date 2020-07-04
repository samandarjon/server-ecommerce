package uz.pdp.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.ecommerce.entity.Feedback;
import uz.pdp.ecommerce.payload.FeedbackMessage;

import java.util.List;
import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
    @Query("select p.id, p.message, u.firstName as user from Feedback p join users u on u.id=p.createdBy where p.id = :id")
    List<FeedbackMessage> getFeedback(@Param("id") UUID id);
}
