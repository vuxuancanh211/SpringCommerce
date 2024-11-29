package org.example.springcommerce.Service;

import org.example.springcommerce.Model.Product;
import org.example.springcommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> showProducts(String keyword, Pageable pageable) {
        return productRepository.findAll(keyword, pageable);
    }

    public Page<Product> showProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> filterProducts(Long categoryId, Long brandId, Double minPrice, Double maxPrice, String color, Pageable pageable) {
        return productRepository.findProductByCriteria(categoryId, brandId, minPrice, maxPrice, color, pageable);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setColor(product.getColor());
            existingProduct.setStock(product.getStock());
            existingProduct.setWeight(product.getWeight());
            existingProduct.setSize(product.getSize());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setImageUrl(product.getImageUrl());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
