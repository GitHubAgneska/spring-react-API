package com.wst.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CustomerRepository repository;
    

    @Autowired
	public DatabaseLoader(CustomerRepository repository) {
		this.repository = repository;
    }
    
    @Override
	public void run(String... strings) throws Exception {

        this.repository.save(new Customer("Nancy", "Botwin", "Agrestic CA"));


    }
}