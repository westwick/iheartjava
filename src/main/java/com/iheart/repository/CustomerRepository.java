package com.iheart.repository;

import com.iheart.model.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Andrew on 5/9/2017.
 */
@Mapper
public interface CustomerRepository {
    void createCustomer(Customer customer);
}
