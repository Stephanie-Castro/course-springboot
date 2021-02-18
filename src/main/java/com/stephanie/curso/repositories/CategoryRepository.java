package com.stephanie.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephanie.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
