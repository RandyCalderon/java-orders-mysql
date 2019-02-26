package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Order;
import com.lambdaschool.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderRepository ordrepos;

    // List all orders
    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = ordrepos.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Get order by id
    @GetMapping("/order/{id}")
    public ResponseEntity<?> orderById(@PathVariable long id) {
        Optional<Order> foundOrder = ordrepos.findById(id);
        if (foundOrder.isPresent()) {
            return new ResponseEntity<>(foundOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


 }
