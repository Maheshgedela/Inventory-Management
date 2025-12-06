package com.example.inventorymanagement.services;

import com.example.inventorymanagement.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
        void save(Product product);
        Product getById(Long id);
        void delete(Long id);

        Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
    }


