package com.mir.controller;

import com.mir.mybatis.vo.CustomerVO;
import com.mir.mybatis.vo.OrderVO;
import com.mir.service.CustomerServiceImpl;
import com.mir.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger("CustomerController");

    @Autowired
    CustomerServiceImpl customerService;

    /**
     * 회원 조회
     * @param custId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{custId}")
    public CustomerVO getCustomerInfo(@PathVariable(value = "custId") String custId){
        logger.info("********* 회원 조회 요청 *********");
        CustomerVO vo = new CustomerVO();
        vo = customerService.getCustomerInfo(custId);
        return vo;
    }

    /**
     * 회원 등록
     * @params
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public void registCustomer(@RequestBody CustomerVO vo){
        logger.info("********* 회원 등록 요청 *********");
        customerService.registCustomer(vo);
    }

    /**
     * 회원 삭제
     * @param custId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{custId}")
    public String removeCustomer(@PathVariable(value="custId") String custId){
        logger.info("********* 회원 삭제 요청 *********");
        customerService.deleteCustomer(custId);
        return "삭제";
    }

    /**
     * 회원 수정
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String modifyCustomer(@RequestBody CustomerVO vo){
        logger.info("********* 회원 수정 요청 *********");
        customerService.updateCustomer(vo);
        return "수정";
    }

    /**
     * 회원 주문 내역 조회
     * @param custNm
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/order/{custNm}")
    public List<OrderVO> getOrderInfo(@PathVariable(value = "custNm") String custNm){
        logger.info("********* 주문 내역 조회 요청 [ID: {}] *********", custNm);
        List<OrderVO> result = customerService.getOrderList(custNm);
        return result;
    }
}
