package com.assignment4.service;

import com.assignment4.model.Product;
import com.assignment4.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> search(String title, String color, String size) {
        if (title != null && !title.isEmpty()) {
            return repo.findByTitleContainingIgnoreCase(title);
        } else if (color != null && !color.isEmpty()) {
            return repo.findByColorContainingIgnoreCase(color);
        } else if (size != null && !size.isEmpty()) {
            return repo.findBySize(size);
        }
        return repo.findAll();
    }
}
