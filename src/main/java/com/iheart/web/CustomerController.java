package com.iheart.web;

import com.iheart.model.Customer;
import com.iheart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrew on 5/9/2017.
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * This will create a customer and return a 200 response on success
     *
     * @param customer must provider customer details (name, contactname, creditlimit)
     * @return
     */
    @RequestMapping(value = "/api/customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/api/customer", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/api/customer",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer(@RequestParam("id") Integer id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/api/customer/check-credit",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkCustomerCredit(@RequestParam("id") Integer id, @RequestParam("amount") Integer amount) {
        return customerService.checkCustomerCredit(id, amount);
    }
}
