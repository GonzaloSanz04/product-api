package com.todoapp.product_api.service;

import com.todoapp.product_api.model.Product;
import com.todoapp.product_api.repository.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRespository repo;

    public ProductService(ProductRespository repo) {
        this.repo = repo;
    }

    public Product create(Product p){
        return repo.save(p);
    }

    public List<Product> listAll() {
        return repo.findAll();
    }

    public Optional<Product> get(Long id) {
        return repo.findById(id);
    }

    public Product update(Long id, Product updated) {
        return repo.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setDescription(updated.getDescription());
            p.setPrice(updated.getPrice());
            p.setStock(updated.getStock());
            p.setCategory(updated.getCategory());
            return repo.save(p);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
