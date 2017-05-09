package com.iheart.repository;

import com.iheart.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Andrew on 5/9/2017.
 */
@Mapper
public interface CustomerMapper {
    @Insert("insert into customers(customerName, contactName, creditLimit) values (#{customerName}, #{contactName}, #{creditLimit})")
    void insert(Customer customer);
}
