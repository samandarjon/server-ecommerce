package uz.pdp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;
import uz.pdp.ecommerce.service.AttachmentService;

import java.util.UUID;

@RestController
@RequestMapping("/api/attach")
public class AttachController {
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFileToServer(MultipartRequest request) {
        return ResponseEntity.ok(attachmentService.save(request));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable UUID id) {
        return attachmentService.download(id);
    }

    @GetMapping("/preview/{id}")
    public ResponseEntity<?> previewFile(@PathVariable UUID id) {
        return attachmentService.preview(id);
    }

}
