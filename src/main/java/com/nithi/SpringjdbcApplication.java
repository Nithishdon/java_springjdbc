package com.nithi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nithi.model.Alien;
import com.nithi.repo.Alien_repo;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=	SpringApplication.run(SpringjdbcApplication.class, args);
		Alien alien1 =context.getBean(Alien.class);
		alien1.setId(1);
		alien1.setName("nithi");
		alien1.setTech("Java");
		
		
		Alien_repo alienrepo=context.getBean(Alien_repo.class);
		alienrepo.save(alien1);
		System.out.println(alienrepo.printall());
	}

}
