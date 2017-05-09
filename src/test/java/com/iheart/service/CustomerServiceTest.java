package com.iheart.service;

import com.iheart.model.Customer;
import com.iheart.repository.CustomerMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Andrew on 5/9/2017.
 */
public class CustomerServiceTest {

    private Customer customer;
    private CustomerService customerService;
    @Mock
    private CustomerMapper mockCustomerMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customer = new Customer();
        customerService = new CustomerServiceImpl(mockCustomerMapper);
    }

    @Test
    public void createCustomer_successCase() throws Exception {
        customerService.createCustomer(customer);
        Mockito.verify(mockCustomerMapper).insert(customer);

    }
}
