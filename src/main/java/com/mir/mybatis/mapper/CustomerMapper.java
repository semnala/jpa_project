package com.mir.mybatis.mapper;

import com.mir.mybatis.vo.CustomerVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerVO selectCustomerById(String custId);

    void insertCustomer(CustomerVO vo);

    void deleteCustomer(String custId);

    void updateCustomer(CustomerVO vo);

}
