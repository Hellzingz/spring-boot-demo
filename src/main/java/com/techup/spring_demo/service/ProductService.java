package com.techup.spring_demo.service;

import com.techup.spring_demo.entity.Product;
import com.techup.spring_demo.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupabaseStorageService supabaseStorageService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(String name, Double price, String description, MultipartFile image) {
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = supabaseStorageService.uploadFile(image);
        }

        Product product = Product.builder()
                .name(name)
                .price(price)
                .description(description)
                .imageUrl(imageUrl)
                .build();

        return productRepository.save(product);
    }
    public Product updateProduct(Long id, String name, Double price, String description, MultipartFile image) {
        Product existing = getProductById(id);

        if (name != null) {
            existing.setName(name);
        }
        if (price != null) {
            existing.setPrice(price);
        }
        if (description != null) {
            existing.setDescription(description);
        }
        if (image != null && !image.isEmpty()) {
            String imageUrl = supabaseStorageService.uploadFile(image);
            existing.setImageUrl(imageUrl);
        }

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        productRepository.delete(existing);
    }
}
