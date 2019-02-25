package com.lambdaschool.orders.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentcode;

    private String agentname;

    private String workingarea;

    private double commission;

    private String phone;

    private String country;

    public Agent() {
    }
}
