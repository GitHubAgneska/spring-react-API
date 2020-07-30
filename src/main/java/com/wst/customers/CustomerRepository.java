package com.wst.customers;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.PagingAndSortingRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {} 


// add spring data rest PAGING support
// ( set page size and adds navigational links )
// public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {}