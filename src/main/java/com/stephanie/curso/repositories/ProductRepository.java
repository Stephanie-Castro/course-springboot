package com.stephanie.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephanie.curso.entities.Product;
import com.stephanie.curso.entities.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
