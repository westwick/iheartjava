package com.iheart.service;

import com.iheart.model.Customer;
import com.iheart.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Andrew on 5/9/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public void createCustomer(Customer customer) {
        //todo: check for null
        customerMapper.insert(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        //todo:
        customerMapper.update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        //todo:
        customerMapper.delete(customer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        //todo:
        return customerMapper.get(id);
    }

    @Override
    public boolean checkCustomerCredit(Integer id, Integer amount) {
        Customer customer = getCustomer(id);
        return customer.hasSufficientCredit(amount);
    }
}
