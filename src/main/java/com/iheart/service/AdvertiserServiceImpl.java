package com.iheart.service;

import com.iheart.model.Advertiser;
import com.iheart.repository.AdvertiserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Andrew on 5/9/2017.
 */
@Service
public class AdvertiserServiceImpl implements AdvertiserService {
    @Autowired
    private AdvertiserMapper advertiserMapper;

    public AdvertiserServiceImpl(AdvertiserMapper advertiserMapper) {
        this.advertiserMapper = advertiserMapper;
    }

    @Override
    public void createAdvertiser(Advertiser advertiser) {
        //todo: check for null
        advertiserMapper.insert(advertiser);
    }

    @Override
    public void updateAdvertiser(Advertiser advertiser) {
        //todo:
        advertiserMapper.update(advertiser);
    }

    @Override
    public void deleteAdvertiser(Advertiser advertiser) {
        //todo:
        advertiserMapper.delete(advertiser);
    }

    @Override
    public Advertiser getAdvertiser(Integer id) {
        //todo:
        return advertiserMapper.get(id);
    }

    @Override
    public boolean checkAdvertiserCredit(Integer id, Integer amount) {
        Advertiser advertiser = getAdvertiser(id);
        return advertiser.hasSufficientCredit(amount);
    }
}
