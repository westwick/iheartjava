package com.iheart.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Andrew on 5/9/2017.
 */
public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
    }

    @Test
    public void hasSufficientCredit_happyCase() {
        customer.setCreditLimit(1000);
        Assert.assertEquals(true, customer.hasSufficientCredit(500));
    }

    @Test
    public void hasSufficientCredit_insufficientCredit() {
        customer.setCreditLimit(20);
        Assert.assertEquals( false, customer.hasSufficientCredit(500));
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasSufficientCredit_invalidAmount() {
        customer.hasSufficientCredit(null);
    }
}
