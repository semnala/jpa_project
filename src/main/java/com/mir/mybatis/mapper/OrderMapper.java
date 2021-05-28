package com.mir.mybatis.mapper;

import com.mir.mybatis.vo.CustomerVO;
import com.mir.mybatis.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderVO selectOrderById(String orderId);

    List<OrderVO> selectOrdersByCustId(String custNm);

    void insertOrder(OrderVO vo);

    int deleteOrder(String orderId);

    int deleteProduct(String productId);

}
