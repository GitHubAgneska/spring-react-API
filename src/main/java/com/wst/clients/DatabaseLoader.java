package com.wst.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ClientRepository repository;
    

    @Autowired
	public DatabaseLoader(ClientRepository repository) {
		this.repository = repository;
    }
    
    @Override
	public void run(String... strings) throws Exception {

        this.repository.save(new Client("Nancy", "Botwin", "Agrestic CA"));


    }
}