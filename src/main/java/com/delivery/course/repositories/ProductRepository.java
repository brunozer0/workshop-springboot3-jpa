package com.delivery.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
