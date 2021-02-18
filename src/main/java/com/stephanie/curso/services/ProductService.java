package com.stephanie.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stephanie.curso.entities.Product;
import com.stephanie.curso.repositories.ProductRepository;

//@Component //anotation do Spring que registra uma classe como componente do Spring
@Service //anotation do Spring que registra uma classe como service do Spring. Também tem @Component e @Repository
public class ProductService {
	
	@Autowired //Com isso o Spring faz a injeção de dependÊncia de forma transparente ao programador
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); //o método get() retorna um objeto do tipo Product que estiver dentro do Optional
	}
}
