package com.mir.service;

import com.mir.jpa.entity.Order;
import com.mir.jpa.repository.OrderRepository;
import com.mir.mybatis.mapper.OrderMapper;
import com.mir.mybatis.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl {

    @Autowired
    OrderMapper mapper;

    @Autowired
    OrderRepository orderRepository;

    /**
     * 주문 정보 조회
     */
    public OrderVO getOrderInfo(String orderId){
        System.out.println("********* 주문 정보 조회 서비스 시작 *********");
        OrderVO order = new OrderVO();
        order = mapper.selectOrderById(orderId);
        return order;
    }

    /**
     * 주문 등록
     */
    public void registOrder(OrderVO vo) throws DuplicateKeyException {
        System.out.println("********* 주문 등록 서비스 시작 *********");
        mapper.insertOrder(vo);
    }

    /**
     * 주문 삭제
     */
    public String removeOrder(String orderId){
        System.out.println("********* 주문 삭제 서비스 시작 *********");
        int result = 0;
        result = mapper.deleteOrder(orderId);
        String resultMsg = (result != 0) ? "삭제완료" : "삭제실패";
        System.out.println(result);
        return resultMsg;
    }

    /**
     * 주문 정보 조회(JPA)
     * Java 8에 추가된 Optional 참고하자
     */
    public Order getOrderInfoByJpa(Long orderId){
        System.out.println("********* 주문 정보 조회 서비스 시작 *********");
        Optional<Order> order = orderRepository.findById(orderId);
        return order.get();
    }

    /**
     * 주문 등록(JPA)
     */
    public void registOrderByJpa(Order vo) throws DuplicateKeyException {
        System.out.println("********* [JPA] 주문 등록 서비스 시작 *********");
        orderRepository.save(vo);
    }

}
