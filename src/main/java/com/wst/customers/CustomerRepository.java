package com.wst.customers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

// import org.springframework.data.repository.PagingAndSortingRepository;


@PreAuthorize("hasRole('ROLE_MANAGER')")
public interface CustomerRepository extends CrudRepository<Customer, Long> {} 


// add spring data rest PAGING support
// ( set page size and adds navigational links )
// public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {}

// @Param = links HTTP operations with the methods
@Override
@PreAuthorize("#customer?.manager == null or #customer?.manager?.name == authentication?.name")
Customer save(@Param(value="customer") Customer customer);


@Override
@PreAuthorize("@customerRepository.findById(#id)?.manager?.name == authentication?.name")
void deleteById(@Param("id") Long id);



@Override
@PreAuthorize("#customer?.manager?.name == authentication?.name")
void delete(@Param("customer") Customer customer);