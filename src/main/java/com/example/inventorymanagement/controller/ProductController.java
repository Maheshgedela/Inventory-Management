package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
        private ProductService service;

        // HOME PAGE → PRODUCT LIST
        @GetMapping("/")
        public String viewHomePage(Model model) {
            return findPaginated(1, "name", "asc", model);
        }

        // PAGINATION + SORTING
        @GetMapping("/page/{pageNo}")
        public String findPaginated(
                @PathVariable int pageNo,
                @RequestParam("sortField") String sortField,
                @RequestParam("sortDir") String sortDir,
                Model model
        ) {
            int pageSize = 5;

            Page<Product> page = service.findPaginated(pageNo, pageSize, sortField, sortDir);
            List<Product> list = page.getContent();

            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());
            model.addAttribute("products", list);

            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

            return "index"; // LIST PAGE
        }

        // DASHBOARD PAGE → NEW URL
        @GetMapping("/dashboard")
        public String dashboard(Model model) {
            List<Product> list = service.getAllProducts();
            model.addAttribute("products", list);
            model.addAttribute("totalItems", list.size());
            return "dashboard";
        }

        // ADD PRODUCT PAGE
        @GetMapping("/add")
        public String addProduct(Model model) {
            model.addAttribute("product", new Product());
            return "new_product";
        }

        // SAVE PRODUCT
        @PostMapping("/save")
        public String saveProduct(@ModelAttribute Product product) {
            service.save(product);
            return "redirect:/";
        }

        // UPDATE PRODUCT PAGE
        @GetMapping("/update/{id}")
        public String updateProduct(@PathVariable Long id, Model model) {
            model.addAttribute("product", service.getById(id));
            return "update_product";
        }

        // DELETE PRODUCT
        @GetMapping("/delete/{id}")
        public String deleteProduct(@PathVariable Long id) {
            service.delete(id);
            return "redirect:/";
        }
    }





