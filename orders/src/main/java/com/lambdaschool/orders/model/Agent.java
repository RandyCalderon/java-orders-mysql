package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long agentcode;

    @OneToMany(mappedBy= "agent")
    @JsonIgnore
    private Set<Customer> customers;

    @OneToMany(mappedBy="agent")
    @JsonIgnore
    private Set<Order> orders;

    @NotNull
    private String agentname;

    private String workingarea;
    private double commission;
    private String phone;
    private String country;


    public Agent() {
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
