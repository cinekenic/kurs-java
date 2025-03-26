package com.kodilla.spring.kodillahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.kodilla.hibernate")
@EnableJpaRepositories(basePackages = {
		"com.kodilla.hibernate.task.dao",
		"com.kodilla.hibernate.tasklist.dao"
})
@EntityScan(basePackages = {
		"com.kodilla.hibernate.task",
		"com.kodilla.hibernate.tasklist"
})
public class KodillaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaHibernateApplication.class, args);
	}

}
