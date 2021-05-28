package com.mir.controller;

import com.mir.service.OrderServiceImpl;
import com.mir.mybatis.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/orders")
public class OrderContoroller {

    @Autowired
    OrderServiceImpl orderService;

    /**
     * 주문 조회
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}")
    public String getOrderInfo(@PathVariable(value = "orderId") String orderId){
        System.out.println("********* 주문 조회 요청 *********");
        OrderVO vo = new OrderVO();
        vo = orderService.getOrderInfo(orderId);
        return vo.getOrderDt();
    }

    /**
     * 주문 등록
     * @params
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public void registOrder(@RequestBody OrderVO vo){
        System.out.println("********* 주문 등록 요청 *********");
        orderService.registOrder(vo);
    }

    /**
     * 주문 삭제
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{orderId}")
    public String deleteOrder(@PathVariable(value="orderId") String orderId){
        System.out.println("********* 주문 삭제 요청 *********");
        String result = "";
        result = orderService.removeOrder(orderId);
        return result;
    }

    /**
     * 주문 수정
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{orderId}")
    public String modifyOrder(@PathVariable(value="orderId") String orderId){
        System.out.println("********* 주문 삭제 요청 *********");
        String result = "";
        result = orderService.removeOrder(orderId);
        return result;
    }


}
