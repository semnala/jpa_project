package com.mir.controller;

import com.mir.jpa.entity.Customer;
import com.mir.jpa.entity.Order;
import com.mir.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/jpa/customer")
public class JpaCustomerController {

    private static Logger logger = LoggerFactory.getLogger("JpaCustomerController");

    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * JPA 회원 조회
     * @param custId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{custId}")
    public Customer getCustomerInfoJpa(@PathVariable(value = "custId") String custId){
        logger.info("********* [JPA] 회원 조회 요청 [ID: "+custId+"] *********");
        Customer customer = customerService.getCustomerInfoByJpa(custId);
        return customer;
    }

    /**
     * JPA 회원 등록
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String registCustomerJpa(@RequestBody Customer vo){
        logger.info("********* [JPA] 회원 등록 요청 *********");
        customerService.registCustomerByJpa(vo);
        return "등록";
    }

    /**
     * JPA 회원 삭제
     * @param custId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{custId}")
    public String removeCustomer(@PathVariable(value="custId") String custId){
        logger.info("********* [JPA] 회원 삭제 요청 *********");
        String result = customerService.deleteCustomerByJpa(custId);
        return result;
    }

    /**
     * JPA 회원 수정
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String modifyCustomer(@RequestBody Customer vo){
        logger.info("********* [JPA] 회원 이름 변경 요청 *********");
        customerService.updateCustomerByJpa(vo);
        return "수정";
    }

    /**
     * JPA 회원 주문 내역 조회
     * @param custNm
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/order/{custNm}")
    public List<Order> getOrdersJpa(@PathVariable(value = "custNm") String custNm) {
        logger.info("********* [JPA] 주문 내역 조회 요청 [Nm: "+custNm+"] *********");
        List<Order> orders = customerService.getOrderListByJpa(custNm);
        return orders;
    }
}
