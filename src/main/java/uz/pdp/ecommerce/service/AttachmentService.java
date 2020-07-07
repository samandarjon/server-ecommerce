package uz.pdp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import uz.pdp.ecommerce.entity.Attachment;
import uz.pdp.ecommerce.entity.AttachmentContent;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.repository.AttachmentContentRepository;
import uz.pdp.ecommerce.repository.AttachmentRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentService {
    @Autowired
    private AttachmentContentRepository attachmentContentRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;


    public List<UUID> save(MultipartRequest request) {
        try {
            Iterator<String> fileNames = request.getFileNames();
            List<UUID> uuidList = new ArrayList<>();
            while (fileNames.hasNext()) {
                MultipartFile file = request.getFile(fileNames.next());
                assert file != null;
                Attachment attachment = new Attachment(
                        file.getOriginalFilename(),
                        file.getSize(),
                        file.getContentType());
                Attachment savedAttachment = attachmentRepository.save(attachment);
                AttachmentContent attachmentContent = new AttachmentContent(savedAttachment, file.getBytes());
                attachmentContentRepository.save(attachmentContent);
                uuidList.add(savedAttachment.getId());
//            uuidList.add(attachmentContentRepository.save(new AttachmentContent(file.getBytes(), attachmentRepository.save(new Attachment(file.getOriginalFilename(), file.getContentType(), file.getSize())))).getAttachment().getId());
            }
            return uuidList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public ResponseEntity<?> download(UUID id) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Bunday file topilmadi"));
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachment(attachment);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;\"" + attachment.getName() + "\"")
                .body(attachmentContent.getContent());

    }

    public ResponseEntity<?> preview(UUID id) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Bunday file topilmadi"));
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachment(attachment);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;\"" + attachment.getName() + "\"")
                .body(attachmentContent.getContent());

    }


}

