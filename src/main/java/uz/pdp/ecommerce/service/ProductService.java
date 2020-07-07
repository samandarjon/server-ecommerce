package uz.pdp.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.ecommerce.entity.Product;
import uz.pdp.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public void getAll(Integer page) {
        Page<Product> all = productRepository.findAll(PageRequest.of(page, 20));


    }
}
