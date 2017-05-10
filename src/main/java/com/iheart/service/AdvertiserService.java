package com.iheart.service;

import com.iheart.model.Advertiser;

/**
 * Created by Andrew on 5/9/2017.
 */
public interface AdvertiserService {

    void createAdvertiser(Advertiser advertiser);
    void updateAdvertiser(Advertiser advertiser);
    void deleteAdvertiser(Advertiser advertiser);
    Advertiser getAdvertiser(Integer id);
    boolean checkAdvertiserCredit(Integer id, Integer amount);
}
