package com.techup.spring_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techup.spring_demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { 
}
