package com.mir.controller;

import com.mir.jpa.entity.Customer;
import com.mir.jpa.entity.Order;
import com.mir.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/jpa/order")
public class JpaOrderController {

    @Autowired
    OrderServiceImpl orderService;

    /**
     * JPA 주문 등록
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String registOrderJpa(@RequestBody HashMap<String, Object> reqParam){
        System.out.println("********* [JPA] 주문 등록 요청 *********");
        Order order = new Order();
        Customer customer = new Customer();
        customer.setId((String)reqParam.get("custId"));
        order.setId(Long.parseLong((String)reqParam.get("id")));
        order.setOrderDt((String)reqParam.get("orderDt"));
        order.setDestination((String)reqParam.get("destination"));
        order.setStatus("1");
        order.setCustomer(customer);
        orderService.registOrderByJpa(order);
        return "등록";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}")
    public Order getOrderJpa(@PathVariable(value = "orderId") Long orderId){
        System.out.println("********* [JPA] 주문 조회 요청 *********");
        Order order = new Order();
        order = orderService.getOrderInfoByJpa(orderId);
        return order;
    }

}
