package com.mir.mybatis.vo;

import lombok.Data;

/**
 * 주문정보 VO
 */
@Data
public class OrderVO {
    private int orderId;
    private String orderDt;
    private String destination;
    private String status;
    private int price;
}
