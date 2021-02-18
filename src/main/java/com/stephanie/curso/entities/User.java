package com.stephanie.curso.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//interface Serializable que define nos objetos quando se quer quer esse objetos
//possam ser transformados em cadeias de bytes para que o objeto trafegue na rede, possa 
//ser gravado em arquivos e outros...
//add default serial version ID
//Colocar anotation do JPA para instruir o JPA como converter os objetos para o modelo relacional //import javax.persistence.Entity;
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremented ID
	private Long id;
	private String nome;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore //ou cliente vai chamar a lista de pedidos que vai mostra cliente, que vai mostra as lsitas, e vai ficar em loop até estourar...
	@OneToMany(mappedBy = "client") //Anotation do jpa Um para muitos, que é mapeado pelo atributo client
	private List<Order> orders = new ArrayList<>();
	
	public User() {
		
	}
	
	//botão direito -> source -> generate constructor using fields
	public User(Long id, String nome, String email, String phone, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	
	//botão direito -> source -> generate getters e setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	
	//botão direito -> source -> generate hashcode() e equals()
	//só para o ID, mas pde fazer pro que quiser
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	//src/main/resources/application-test.properties
		//acessar 	http://localhost:8080/h2-console
			//JDBC URL: jdbc:h2:mem:testdb
			//user: sa
			//password:
	
	
	
	

}
