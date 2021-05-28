package com.mir.mybatis.vo;

import lombok.Data;

/**
 * 고객정보 VO
 */
@Data
public class CustomerVO {
    private String custId;
    private String custNm;
    private String phone;
    private String address;
    private String status;
}
