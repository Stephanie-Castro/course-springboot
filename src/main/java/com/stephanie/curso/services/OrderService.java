package com.stephanie.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stephanie.curso.entities.Order;
import com.stephanie.curso.repositories.OrderRepository;

//@Component //anotation do Spring que registra uma classe como componente do Spring
@Service //anotation do Spring que registra uma classe como service do Spring. Também tem @Component e @Repository
public class OrderService {
	
	@Autowired //Com isso o Spring faz a injeção de dependÊncia de forma transparente ao programador
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); //o método get() retorna um objeto do tipo Order que estiver dentro do Optional
	}
}
