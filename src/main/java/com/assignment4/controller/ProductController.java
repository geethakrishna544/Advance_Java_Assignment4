package com.assignment4.controller;

import com.assignment4.model.Product;
import com.assignment4.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String listProducts(@RequestParam(required = false) String keyword,
                               @RequestParam(required = false) String size,
                               @RequestParam(required = false) String color,
                               Model model) {

        List<Product> products = productRepository.findAll();

        // Simple filtering
        if (keyword != null && !keyword.isEmpty()) {
            products = products.stream()
                    .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (size != null && !size.isEmpty()) {
            products = products.stream()
                    .filter(p -> p.getSize().equalsIgnoreCase(size))
                    .collect(Collectors.toList());
        }
        if (color != null && !color.isEmpty()) {
            products = products.stream()
                    .filter(p -> p.getColor().equalsIgnoreCase(color))
                    .collect(Collectors.toList());
        }

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        model.addAttribute("size", size);
        model.addAttribute("color", color);

        return "search"; // maps to search.html
    }
}
