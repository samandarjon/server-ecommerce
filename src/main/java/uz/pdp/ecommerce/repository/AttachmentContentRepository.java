package uz.pdp.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Attachment;
import uz.pdp.ecommerce.entity.AttachmentContent;

import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    AttachmentContent findByAttachmentId(UUID id);

    AttachmentContent findByAttachment(Attachment attachment);
}
