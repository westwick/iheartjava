package com.iheart.service;

import com.iheart.model.Customer;

/**
 * Created by Andrew on 5/9/2017.
 */
public interface CustomerService {

    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer getCustomer(Integer id);
    boolean checkCustomerCredit(Integer id, Integer amount);
}
