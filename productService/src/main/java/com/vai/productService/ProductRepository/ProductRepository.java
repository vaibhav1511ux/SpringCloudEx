package com.vai.productService.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vai.productService.productDTO.Product;

public interface ProductRepository  extends JpaRepository<Product,Integer>{

}
