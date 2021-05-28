package com.mir.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.builder.ToStringBuilder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer 테이블 매핑 엔티티
 *
 * @author 박경용
 */
@Entity
@Table
@Data
public class Customer {
    @Id
    @Column(name="cust_id")
    private String id;

    @Column(name="cust_nm")
    private String name;

    @Column(name="cust_phone")
    private String phone;

    @Column(name="cust_address")
    private String address;

    @Column(name="cust_status")
    private String status;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    //@JsonIgnoreProperties({"customer"}) // customer에 의해 호출된 order에서는 customer 자료를 가져오지 않는다.
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return ToStringBuilder
                .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
