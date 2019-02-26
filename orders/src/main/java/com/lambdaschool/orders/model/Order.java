package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long ordnum;

    private double ordamount;

    private double advanceamount;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customer customer;

    private String orddescription;

    public Order() {
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }
}
