package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Agent;
import com.lambdaschool.orders.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/agents", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController {
    @Autowired
    AgentRepository agentrepos;

    // List all Agents
    @GetMapping("/agents")
    public List<Agent> listAllAgents() {
        return agentrepos.findAll();
    }
}
