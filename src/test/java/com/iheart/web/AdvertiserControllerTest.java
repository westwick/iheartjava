package com.iheart.web;

import com.iheart.model.Advertiser;
import com.iheart.service.AdvertiserService;
import com.iheart.service.AdvertiserServiceImpl;
import org.joor.Reflect;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by Andrew on 5/10/2017.
 */
public class AdvertiserControllerTest {

    @Mock
    private AdvertiserService mockAdvertiserService;
    private AdvertiserController advertiserController;
    private final Advertiser advertiser = new Advertiser("company", "contact", 1000);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        advertiserController = new AdvertiserController();
        Reflect.on(advertiserController).set("advertiserService", mockAdvertiserService);
    }

    @Test
    public void createAdvertiser_successCase() throws Exception {
        ResponseEntity response = advertiserController.createAdvertiser(advertiser);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(mockAdvertiserService).createAdvertiser(advertiser);
    }

    @Test
    public void updateAdvertiser_successCase() throws Exception {
        advertiser.setId(1L);
        ResponseEntity response = advertiserController.updateAdvertiser(advertiser);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(mockAdvertiserService).updateAdvertiser(advertiser);
    }

    @Test
    public void updateAdvertiser_badRequest() throws Exception {
        ResponseEntity response = advertiserController.updateAdvertiser(advertiser);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void deleteAdvertiser_successCase() throws Exception {
        advertiser.setId(1L);
        ResponseEntity response = advertiserController.deleteAdvertiser(advertiser);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(mockAdvertiserService).deleteAdvertiser(advertiser);
    }

    @Test
    public void deleteAdvertiser_badRequest() throws Exception {
        //todo
    }

    @Test
    public void getAdvertiser_successCase() throws Exception {
        Mockito.when(mockAdvertiserService.getAdvertiser(1)).thenReturn(advertiser);
        ResponseEntity response = advertiserController.getAdvertiser(1);
        Assert.assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        Assert.assertEquals(advertiser, response.getBody());
        Mockito.verify(mockAdvertiserService).getAdvertiser(1);
    }

    @Test
    public void getAdvertiser_notFound() throws Exception {
        //todo
    }

    @Test
    public void checkAdvertiserCredit_successCase() throws Exception {
        Mockito.when(mockAdvertiserService.checkAdvertiserCredit(1, 1000)).thenReturn(true);
        Assert.assertEquals(true, advertiserController.checkAdvertiserCredit(1, 1000));
        Mockito.verify(mockAdvertiserService).checkAdvertiserCredit(1, 1000);
    }
}
