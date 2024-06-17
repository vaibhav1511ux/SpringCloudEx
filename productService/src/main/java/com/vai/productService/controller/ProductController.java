package com.vai.productService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vai.productService.ProductRepository.ProductRepository;

import java.util.List;
import com.vai.productService.productDTO.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins ="http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductRepository productrepository;

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> products = productrepository.findAll();
        return products;
    }

   

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        // Product product = new Product();
        // product.setName(product.getName());
        // product.setPrice(productDto.getPrice());
        // product.setPicture(productDto.getPicture()); // or setPictureUrl(productDto.getPictureUrl())

        return productrepository.save(product);
    }
    // Other methods for handling product pictures, such as uploading, updating, etc.

}
