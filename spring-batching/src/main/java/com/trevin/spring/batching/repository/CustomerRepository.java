package com.trevin.spring.batching.repository;

import com.trevin.spring.batching.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

}
