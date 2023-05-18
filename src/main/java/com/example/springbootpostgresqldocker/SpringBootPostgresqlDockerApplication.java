package com.example.springbootpostgresqldocker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringBootPostgresqlDockerApplication
{
	private final CustomerRepository repository;

	public SpringBootPostgresqlDockerApplication(CustomerRepository repository)
	{
		this.repository = repository;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootPostgresqlDockerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup()
	{
		List<Customer> allCustomers = this.repository.findAll();
		log.info("Number of customers: " + allCustomers.size());

		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Doe");
		log.info("Saving new customer...");
		this.repository.save(newCustomer);

		allCustomers = this.repository.findAll();
		log.info("Number of customers: " + allCustomers.size());
	}
}
