package org.example.springcommerce.Service;

import org.example.springcommerce.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> showProducts(Pageable pageable);
    Page<Product> showProducts(String keyword, Pageable pageable);
    Page<Product> filterProducts(Long categoryId, Long brandId, Double minPrice, Double maxPrice, String color, Pageable pageable);
    Product getProduct(Long id);

    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
