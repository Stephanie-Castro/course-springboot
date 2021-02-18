package com.stephanie.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stephanie.curso.entities.Product;
import com.stephanie.curso.services.ProductService;

//ctrl + space o eclipse completa o comando (ou dá sugestôes)

@RestController //anotation em cima do nome da classe
@RequestMapping(value = "/products")  //nome do recurso. Como é um recurso relacionado a entidade Product, o caminho será /Products
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	//Método que será um endpoint para acessar e retornar os usuários
	//O retorno desse método é um ResponseEntity, que é um tipo específico do Spring para retornar respostas de requisições web. Será do tipo Product
	//Para indicar que esse método é um método que responde a requisição GET do http, usamos uma anotation @GetMapping
	//Acessar http://localhost:8080/Products para reslizar o primeiro teste
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		//Product u = new Product(1L, "Chiquinha da Silva", "chica@xicara.com", "999999999", "Fofinha"); //O 1L é poque o id é do tipo Long
		
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list); //retorna o ResponseEntity, com ok, para retornar a resposta com sucesso no http, .body para reotrnar o corpo da resposta esse usuário u que acabou de ser instanciado
	}
	
	@GetMapping(value = "/{id}") //na url vai passar o id do usuário. Para falar que a url vai ter um parâmetro id
	public ResponseEntity<Product> findById(@PathVariable Long id){//Usamos a anotation @PathVariable para que o Spring aceite o ID e considerá-lo como parâmetro que vai chegar na url
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		//http://localhost:8080/Products/1 no navegador ou no postman para visualizar
	}
}
