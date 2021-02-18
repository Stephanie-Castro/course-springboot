package com.stephanie.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stephanie.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
