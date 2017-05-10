package com.iheart.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Andrew on 5/9/2017.
 */
public class AdvertiserTest {

    private Advertiser advertiser;

    @Before
    public void setUp() throws Exception {
        advertiser = new Advertiser();
    }

    @Test
    public void hasSufficientCredit_successCase() {
        advertiser.setCreditLimit(1000);
        Assert.assertEquals(true, advertiser.hasSufficientCredit(500));
    }

    @Test
    public void hasSufficientCredit_failureCase() {
        advertiser.setCreditLimit(20);
        Assert.assertEquals( false, advertiser.hasSufficientCredit(500));
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasSufficientCredit_invalidAmount() {
        advertiser.hasSufficientCredit(null);
    }
}
