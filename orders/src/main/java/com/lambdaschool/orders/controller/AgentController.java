package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Agent;
import com.lambdaschool.orders.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/agents", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController {
    @Autowired
    AgentRepository agentrepos;

    // List all Agents
    @GetMapping
    public ResponseEntity<?> getAllAgents() {
        List<Agent> agents = agentrepos.findAll();
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }

    // Get agent by id
    @GetMapping("/agent/{id}")
    public ResponseEntity<?> agentById(@PathVariable long id) {
        Optional<Agent> foundAgent = agentrepos.findById(id);
        if (foundAgent.isPresent()) {
            return new ResponseEntity<>(foundAgent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
