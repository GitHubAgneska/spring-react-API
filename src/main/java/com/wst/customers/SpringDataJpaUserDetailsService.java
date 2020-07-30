package com.wst.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

	private final ManagerRepository repository;

	@Autowired
	public SpringDataJpaUserDetailsService(ManagerRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Manager manager = this.repository.findByName(name);
        return new User(manager.getName(), manager.getPassword(),
                //transition from an array of string-based roles into a Java List 
                // of type GrantedAuthority
				AuthorityUtils.createAuthorityList(manager.getRoles()));
	}

}