package com.delivery.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
