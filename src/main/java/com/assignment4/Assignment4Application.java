package com.assignment4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.assignment4.model.Product;
import com.assignment4.repository.ProductRepository;

@SpringBootApplication
public class Assignment4Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment4Application.class, args);
    }

    // Preload sample data
    @Bean
    CommandLineRunner initData(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("Nike T-Shirt", "M", "Red", 799.0));
            productRepository.save(new Product("Adidas T-Shirt", "L", "Blue", 899.0));
            productRepository.save(new Product("Puma T-Shirt", "S", "Black", 699.0));
            productRepository.save(new Product("HRX T-Shirt", "XL", "White", 999.0));
            productRepository.save(new Product("Under Armour T-Shirt", "M", "Grey", 1199.0));
        };
    }
}
