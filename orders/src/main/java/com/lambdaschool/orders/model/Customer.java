package com.lambdaschool.orders.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String custcity;

    private String workingarea;

    private String custcountry;

    private String grade;

    private double openingamt;

    private double receiveamt;

    private double outstandingamt;

    private String phone;

    public Customer() {
    }
}
