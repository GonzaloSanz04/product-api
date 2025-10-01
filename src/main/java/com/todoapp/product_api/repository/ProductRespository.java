package com.todoapp.product_api.repository;

import com.todoapp.product_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
}
