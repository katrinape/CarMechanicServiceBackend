package com.ptaku.jascms.rest;

import com.ptaku.jascms.entity.CustomerEntity;
import com.ptaku.jascms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class CustomerResource {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("customers")
    public ResponseEntity<Iterable<CustomerEntity>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
