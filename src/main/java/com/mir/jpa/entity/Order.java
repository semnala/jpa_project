package com.mir.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;

/**
 * Order 테이블 매핑 엔티티
 *
 * @author 박경용
 */
@Entity
@Table(name="Order_info")
@Data
public class Order {
    @Id
    @Column(name="order_id")
    private Long id;

    @Column(name="order_dt")
    private String orderDt;

    @Column(name="destination")
    private String destination;

    @ManyToOne
    @JoinColumn(name="cust_id")
    @JsonBackReference
    private Customer customer;

    @Column(name="status")
    private String status;

    @Column(name="price")
    private int price;
}
