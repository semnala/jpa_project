package com.mir.jpa.repository;

import com.mir.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /* select * from customer where cust_id ...*/
    Customer findById(String id);

    /* select * from customer where name like ....*/
    Customer findByNameLike(String name);

    /* select count(name) from Customer where cust_nm ... */
    int countByName(String name);

    /* delete from Customer where cust_id ...*/
    @Transactional
    int deleteById(String id);
}
