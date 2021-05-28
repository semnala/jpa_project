package com.mir.service;

import com.mir.jpa.entity.Customer;
import com.mir.jpa.entity.Order;
import com.mir.jpa.repository.CustomerRepository;
import com.mir.jpa.repository.OrderRepository;
import com.mir.mybatis.mapper.CustomerMapper;
import com.mir.mybatis.mapper.OrderMapper;
import com.mir.mybatis.vo.CustomerVO;
import com.mir.mybatis.vo.OrderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl {

    private static Logger logger = LoggerFactory.getLogger("CustomerServiceImpl");

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 고객 정보 조회
     */
    public CustomerVO getCustomerInfo(String id){
        logger.info("********* [Mybatis] 고객 조회 서비스 시작 *********");
        CustomerVO vo = new CustomerVO();
        vo = customerMapper.selectCustomerById(id);
        logger.info("********* [Mybatis] 고객 조회 서비스 종료 *********");
        return vo;
    }

    /**
     *
     * 고객 정보 등록
     */
    public void registCustomer(CustomerVO vo) throws DuplicateKeyException {
        logger.info("********* [Mybatis] 고객 등록 서비스 시작 *********");
        customerMapper.insertCustomer(vo);
        logger.info("********* [Mybatis] 고객 등록 서비스 종료 *********");
    }

    /**
     * 고객 정보 삭제
     */
    public void deleteCustomer(String id) {
        logger.info("********* [Mybatis] 고객 삭제 서비스 시작 *********");
        customerMapper.deleteCustomer(id);
        logger.info("********* [Mybatis] 고객 삭제 서비스 종료 *********");
    }

    /**
     * 고객 정보 수정
     */
    public void updateCustomer(CustomerVO vo) {
        logger.info("********* [Mybatis] 고객 수정 서비스 시작 *********");
        customerMapper.updateCustomer(vo);
        logger.info("********* [Mybatis] 고객 수정 서비스 종료 *********");
    }

    /**
     * 고객 주문 정보 조회
     */
    public List<OrderVO> getOrderList(String name){
        logger.info("********* [Mybatis] 고객 주문 조회 서비스 시작 *********");
        List<OrderVO> orderList = new ArrayList<>();
        orderList = orderMapper.selectOrdersByCustId(name);
        logger.info("********* [Mybatis] 고객 주문 조회 서비스 종료 *********");
        return orderList;
    }

    /**
     * 고객 정보 조회(JPA)
     */
    public Customer getCustomerInfoByJpa(String id){
        logger.info("********* [JPA] 고객 조회 서비스 시작 *********");
        Customer customer = customerRepository.findById(id);
        //logger.info("****** 고객 갯수 : "+customerRepository.countByName(customer.getName()));
        logger.info("********* [JPA] 고객 조회 서비스 종료 *********");
        return customer;
    }

    /**
     * 고객 정보 등록(JPA)
     */
    public void registCustomerByJpa(Customer vo) {
        logger.info("********* [JPA] 고객 등록 서비스 시작 *********");
        customerRepository.save(vo);
        logger.info("********* [JPA] 고객 등록 서비스 종료 *********");

    }

    /**
     * 고객 정보 삭제(JPA)
     */
    public String deleteCustomerByJpa(String id) {
        logger.info("********* [JPA] 고객 삭제 서비스 시작 *********");
        int result = customerRepository.deleteById(id);
        String resultMsg = "";
        if (result == 0) {
            resultMsg = "삭제에 실패하였습니다. 삭제할 데이터가 없습니다";
        } else {
            resultMsg = "삭제 성공 하였습니다.";
        }
        logger.info("********* [JPA] 고객 삭제 서비스 종료 *********");
        return resultMsg;
    }

    /**
     * 고객 정보 수정(JPA)
     */
    public void updateCustomerByJpa(Customer vo) {
        logger.info("********* [JPA] 고객 수정 서비스 시작 *********");
        Customer findCustomer = customerRepository.findById(vo.getId());
        findCustomer.setName(vo.getName());
        customerRepository.save(findCustomer);
        logger.info("********* [JPA] 고객 수정 서비스 종료 *********");
    }

    /**
     * 고객 주문 정보 조회(JPA)
     */
    public List<Order> getOrderListByJpa(String custNm){
        logger.info("********* [JPA] 고객 주문 정보 조회 서비스 시작 *********");
        //List<Order> result = customerRepository.findById(id).getOrders();

        Customer customer = customerRepository.findByNameLike(custNm);
        //List<Order> result = orderRepository.findByCustomer(customer);
        List<Order> result = customer.getOrders();
        logger.info("********* [JPA] 고객 주문 정보 조회 서비스 종료 *********");
        return result;
    }
}
