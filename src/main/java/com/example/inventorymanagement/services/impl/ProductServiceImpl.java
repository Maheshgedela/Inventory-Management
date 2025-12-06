package com.example.inventorymanagement.services.impl;

import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.repository.ProductRepository;
import com.example.inventorymanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
        private ProductRepository repo;

        @Override
        public List<Product> getAllProducts() {
            return repo.findAll();
        }

        @Override
        public void save(Product product) {
            repo.save(product);
        }

        @Override
        public Product getById(Long id) {
            return repo.findById(id).orElse(null);
        }

        @Override
        public void delete(Long id) {
            repo.deleteById(id);
        }

        @Override
        public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
            Sort sort = sortDir.equalsIgnoreCase("asc") ?
                    Sort.by(sortField).ascending() :
                    Sort.by(sortField).descending();

            Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
            return repo.findAll(pageable);
        }
    }



