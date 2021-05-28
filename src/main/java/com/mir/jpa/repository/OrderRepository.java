package com.mir.jpa.repository;

import com.mir.jpa.entity.Customer;
import com.mir.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);
}
