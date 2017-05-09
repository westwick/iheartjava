package com.iheart.repository;

import com.iheart.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Andrew on 5/9/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryIntegrationTest {
    @Autowired
    CustomerMapper customerMapper;

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("test");
        customer.setContactName("Andrew");
        customer.setCreditLimit(1000);
        customerMapper.insert(customer);

    }
}
