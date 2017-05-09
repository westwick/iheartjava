package com.iheart.repository;

import com.iheart.model.Customer;
import org.apache.ibatis.annotations.*;

/**
 * Created by Andrew on 5/9/2017.
 */
@Mapper
public interface CustomerMapper {
    @Insert("insert into customers(customerName, contactName, creditLimit) values (#{customerName}, #{contactName}, #{creditLimit})")
    void insert(Customer customer);

    @Update("update customers set customerName=#{customerName}, contactName=#{contactName}, creditLimit=#{creditLimit} where id=#{id}")
    void update(Customer customer);

    @Delete("delete from customers where id=#{id}")
    void delete(Customer customer);

    @Select("select * from customers where id=#{id}")
    Customer get(Integer id);
}
