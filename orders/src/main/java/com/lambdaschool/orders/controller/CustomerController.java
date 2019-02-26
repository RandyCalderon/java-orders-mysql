package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Get customer by id
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> customerById(@PathVariable long id) {
        Optional<Customer> foundCustomer = custrepos.findById(id);
        if (foundCustomer.isPresent()) {
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get customer by name
    @GetMapping("/{name}")
    public List<Customer> customerByName(@PathVariable String name) {
        return custrepos.findByName(name);
    }

    // Get all customers orders
    @GetMapping("/orders")
    public List<Object[]> customerOrders() {
        return custrepos.findCustomerOrders();
    }

    // Get customers orders by Id
    @GetMapping("/orders/{id}")
    public List<Object[]> customerOrdersById(@PathVariable long id) {

        return custrepos.findCustomerOrderById(id);
//        if (foundOrders != null) {
//            return foundOrders;
//        } else {
//            return null;
//        }
    }

    // Delete by id
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long id) {
        Optional<Customer> foundCustomer = custrepos.findById(id);
        if (foundCustomer.isPresent()) {
            custrepos.deleteById(id);
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
