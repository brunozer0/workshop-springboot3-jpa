package com.delivery.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
