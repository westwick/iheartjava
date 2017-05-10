package com.iheart.service;

import com.iheart.model.Advertiser;
import com.iheart.repository.AdvertiserMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Andrew on 5/9/2017.
 */
public class AdvertiserServiceTest {

    private Advertiser advertiser;
    private AdvertiserService advertiserService;
    @Mock
    private AdvertiserMapper mockAdvertiserMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        advertiser = new Advertiser();
        advertiserService = new AdvertiserServiceImpl(mockAdvertiserMapper);
    }

    @Test
    public void createAdvertiser_successCase() throws Exception {
        advertiserService.createAdvertiser(advertiser);
        Mockito.verify(mockAdvertiserMapper).insert(advertiser);
    }

    @Test
    public void updateAdvertiser_successCase() throws Exception {
        advertiserService.updateAdvertiser(advertiser);
        Mockito.verify(mockAdvertiserMapper).update(advertiser);
    }

    @Test
    public void deleteAdvertiser_successCase() throws Exception {
        advertiserService.deleteAdvertiser(advertiser);
        Mockito.verify(mockAdvertiserMapper).delete(advertiser);
    }

    @Test
    public void getAdvertiser_successCase() throws Exception {
        advertiserService.getAdvertiser(1);
        Mockito.verify(mockAdvertiserMapper).get(1);
    }

    @Test
    public void checkAdvertiserCredit_successCase() throws Exception {
        Mockito.when(mockAdvertiserMapper.get(1)).thenReturn(new Advertiser("Dummy", "Contact", 2000));
        advertiserService.checkAdvertiserCredit(1, 1000);
        Mockito.verify(mockAdvertiserMapper).get(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAdvertiserCredit_AdvertiserNotFound() throws Exception {
        Mockito.when(mockAdvertiserMapper.get(1)).thenReturn(null);
        advertiserService.checkAdvertiserCredit(1, 1000);
        Mockito.verify(mockAdvertiserMapper).get(1);
    }
}
