package com.assignment4.service;

import com.assignment4.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> search(String title, String color, String size);
}
