package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    @Autowired
    CustomerRepository custrepos;

    // List all Customers
    @GetMapping
    public ResponseEntity<?> getAllCustomer() {
        List<Customer> customers = custrepos.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //

}
