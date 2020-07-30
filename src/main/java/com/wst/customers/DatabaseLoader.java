package com.wst.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CustomerRepository repository; // customers ?
    private final ManagerRepository managers;
    

    @Autowired
	public DatabaseLoader(CustomerRepository repository, ManagerRepository managerRepository) {
        this.repository = repository; // this.customers = customerRepository ?
        this.managers = managerRepository;
    }
    
    @Override
	public void run(String... strings) throws Exception {

        Manager hag = this.managers.save(new Manager("hag", "hag",
                            "ROLE_MANAGER"));

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken("hag", "xxxx",
            AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
                            


        this.repository.save(new Customer("Nancy", "Botwin", "Agrestic CA", hag));
        this.repository.save(new Customer("Bojack", "Horseman", "Hollywoo CA", hag));
        this.repository.save(new Customer("Brian", "Griffin", "Quahog Rhode Island", hag));



        SecurityContextHolder.clearContext();
    }
}

