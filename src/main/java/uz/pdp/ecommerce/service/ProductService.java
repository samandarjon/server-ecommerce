package uz.pdp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Attachment;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.exceptions.MethodNotAllowed;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.ProductDto;
import uz.pdp.ecommerce.repository.AttachmentRepository;
import uz.pdp.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    public Page<Product> getAll(Integer page, UUID user) {
        if (user == null) {
            return productRepository.findAll(PageRequest.of(page, 20));
        }
        return productRepository.findAllByCreatedBy(user, PageRequest.of(page, 20));

    }

    public Product getOne(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Bunday mahsulot topilmadi."));
    }

    public Product update(ProductDto productDto, UUID productId, UUID user) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Bunday mahsulot topilmadi."));
        if (!product.getCreatedBy().equals(user))
            throw new MethodNotAllowed("Siz uchun bunday amaliyot mumkin emas.");
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setAboutMoreProduct(productDto.getAboutMoreProduct());
        List<Stream<Attachment>> collect = productDto.getFiles().stream().map(uuid ->
                product.getAttachments().stream().map(attachment -> {
                    if (!uuid.equals(attachment.getId())) {
                        return attachmentRepository.findById(uuid)
                                .orElseThrow(() -> new NotFoundException("Bunday file topilmadi."));
                    }
                    return attachment;
                })).collect(Collectors.toList());
        return productRepository.save(product);
    }

    public ApiResponse delete(UUID id) {
        productRepository.deleteById(id);
        return new ApiResponse("Mahsulot o`chirildi", 200);
    }
}
