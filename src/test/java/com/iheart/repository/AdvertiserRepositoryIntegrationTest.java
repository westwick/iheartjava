package com.iheart.repository;

import com.iheart.model.Advertiser;
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
public class AdvertiserRepositoryIntegrationTest {
    @Autowired
    AdvertiserMapper advertiserMapper;

    @Test
    public void createCustomer() {
        Advertiser advertiser = new Advertiser();
        advertiser.setAdvertiserName("test");
        advertiser.setContactName("Andrew");
        advertiser.setCreditLimit(1000);
        advertiserMapper.insert(advertiser);

    }
}
