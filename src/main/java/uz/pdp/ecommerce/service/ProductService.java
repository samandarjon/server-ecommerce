package uz.pdp.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Attachment;
import uz.pdp.ecommerce.entity.Category;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.exceptions.MethodNotAllowed;
import uz.pdp.ecommerce.exceptions.NotFoundException;
import uz.pdp.ecommerce.payload.ApiResponse;
import uz.pdp.ecommerce.payload.ProductDto;
import uz.pdp.ecommerce.repository.AttachmentRepository;
import uz.pdp.ecommerce.repository.CategoryRepository;
import uz.pdp.ecommerce.repository.ProductRepository;
import uz.pdp.ecommerce.utils.convertors.ProductConverter;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Product> getAll(Integer page, UUID user) {
        if (user == null || user.toString().isEmpty()) {
            return productRepository.findAll(PageRequest.of(page, 20));
        }
        return productRepository.findAllByCreatedBy(user, PageRequest.of(page, 20));

    }

    public Product getOne(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Bunday mahsulot topilmadi."));
    }

    public Product update(ProductDto productDto, UUID productId, UUID user) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Bunday mahsulot topilmadi."));
        if (product.getAttachments().get(0).getId() != productDto.getFiles().get(0)) {
            List<Attachment> attachments = attachmentRepository.findAllByIdIn(productDto.getFiles());
            if (attachments.size() <= 0) {
                throw new NotFoundException("Photo not found.");
            }
            product.setAttachments(attachments);
        }
        if (!product.getCreatedBy().equals(user))
            throw new MethodNotAllowed("Siz uchun bunday amaliyot mumkin emas.");
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setAboutMoreProduct(productDto.getAboutMoreProduct());
        return productRepository.save(product);
    }

    public Product add(ProductDto productDto, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()
                -> new NotFoundException("Bunday Kategoriya mavjud emas."));
        Product product = productConverter.productDtoToProduct(productDto);
        List<Attachment> attachments = attachmentRepository.findAllByIdIn(productDto.getFiles());
        product.setAttachments(attachments);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public ApiResponse delete(UUID id) {
        productRepository.deleteById(id);
        return new ApiResponse("Mahsulot o`chirildi", 200);
    }

    public Page<Product> getAllProductByCategory(Integer page, String category) {
        if (category.equalsIgnoreCase("all"))
            return productRepository.findAll(PageRequest.of(page, 20));
        return productRepository.findAllByCategoryName(category, PageRequest.of(page, 20));
    }
}
