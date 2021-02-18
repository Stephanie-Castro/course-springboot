package com.stephanie.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stephanie.curso.entities.Order;
import com.stephanie.curso.entities.User;
import com.stephanie.curso.entities.enums.OrderStatus;
import com.stephanie.curso.repositories.OrderRepository;
import com.stephanie.curso.repositories.UserRepository;

@Configuration
@Profile("test") //o nome tem que ser igualzinho ao que está em src/main/resources/application.properties spring.profiles.active
public class TestConfig implements CommandLineRunner { //ao implementar CommandLineRunner, e então implementar os métodos necessários, ele implementa o método run, onde tudo que for colocado nele, será executado automaticamente
	
	@Autowired //anotation usada para que o Spring ocnsiga resolver essa dependencia e associar uma instância do UserReposotory no TestConfig
	private UserRepository userReposotory;
	
	@Autowired
	private OrderRepository orderReposotory;

	@Override
	public void run(String... args) throws Exception { //tudo aqui dentro será rodado automaticamente
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
		
		userReposotory.saveAll(Arrays.asList(u1, u2)); //apartir do objeto userReposotory, chamamos a operação savelAll que passa uma lista de usuários que irá ser salva no Banco de Dados
		orderReposotory.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
