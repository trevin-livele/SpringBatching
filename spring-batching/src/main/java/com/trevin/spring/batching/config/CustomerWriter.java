package com.trevin.spring.batching.config;

import com.trevin.spring.batching.entity.Customer;
import com.trevin.spring.batching.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerWriter implements ItemWriter<Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void write(List<? extends Customer> list) throws Exception {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        customerRepository.saveAll(list);
    }
}
