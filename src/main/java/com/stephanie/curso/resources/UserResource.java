package com.stephanie.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stephanie.curso.entities.User;

//ctrl + space o eclipse completa o comando (ou dá sugestôes)

@RestController //anotation em cima do nome da classe
@RequestMapping(value = "/users")  //nome do recurso. Como é um recurso relacionado a entidade User, o caminho será /users
public class UserResource {
	
	//Método que será um endpoint para acessar e retornar os usuários
	//O retorno desse método é um ResponseEntity, que é um tipo específico do Spring para retornar respostas de requisições web. Será do tipo User
	//Para indicar que esse método é um método que responde a requisição GET do http, usamos uma anotation @GetMapping
	//Acessar http://localhost:8080/users para reslizar o primeiro teste
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Chiquinha da Silva", "chica@xicara.com", "999999999", "Fofinha"); //O 1L é poque o id é do tipo Long
		return ResponseEntity.ok().body(u); //retorna o ResponseEntity, com ok, para retornar a resposta com sucesso no http, .body para reotrnar o corpo da resposta esse usuário u que acabou de ser instanciado
	}
}
