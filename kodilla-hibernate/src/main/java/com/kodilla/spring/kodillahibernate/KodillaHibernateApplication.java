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
		"com.kodilla.hibernate.tasklist.dao",
		"com.kodilla.hibernate.manytomany.dao",
		"com.kodilla.hibernate.invoice.dao"
})
@EntityScan(basePackages = {
		"com.kodilla.hibernate.task",
		"com.kodilla.hibernate.tasklist",
		"com.kodilla.hibernate.manytomany",
		"com.kodilla.hibernate.invoice",
})
public class KodillaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaHibernateApplication.class, args);
	}

}
