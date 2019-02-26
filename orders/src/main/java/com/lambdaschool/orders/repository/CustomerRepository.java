package com.lambdaschool.orders.repository;

import com.lambdaschool.orders.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customers WHERE custname = :name", nativeQuery = true)
    List<Customer> findByName(@Param("name") String name);

    @Query(value = "SELECT custname, custcountry, grade, openingamt, outstandingamt, paymentamt, phone, receiveamt, ordnum, advanceamount,ordamount, orddescription FROM customers c, orders o WHERE o.custcode = c.custcode", nativeQuery = true)
    List<Object[]> findCustomerOrders();

    @Query(value = "SELECT c.custcode, o.ordnum FROM customers AS c INNER JOIN orders AS o WHERE c.custcode LIKE :id AND o.custcode LIKE :id", nativeQuery = true)
    List<Object[]> findCustomerOrderById(@Param("id") long id);
}
