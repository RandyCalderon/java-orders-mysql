package com.lambdaschool.orders.repository;

import com.lambdaschool.orders.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Long> {
}
