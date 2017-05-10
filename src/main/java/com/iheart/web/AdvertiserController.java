package com.iheart.web;

import com.iheart.model.Advertiser;
import com.iheart.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrew on 5/9/2017.
 */
@RestController
public class AdvertiserController {
    @Autowired
    private AdvertiserService advertiserService;

    /**
     * This will create a advertiser and return a 200 response on success
     *
     * @param advertiser must provider advertiser details (name, contactname, creditlimit)
     * @return
     */
    @RequestMapping(value = "/api/advertiser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAdvertiser(@RequestBody Advertiser advertiser) {
        advertiserService.createAdvertiser(advertiser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/api/advertiser", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAdvertiser(@RequestBody Advertiser advertiser) {
        advertiserService.updateAdvertiser(advertiser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/api/advertiser", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAdvertiser(@RequestBody Advertiser advertiser) {
        advertiserService.deleteAdvertiser(advertiser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/api/advertiser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Advertiser getAdvertiser(@RequestParam("id") Integer id) {
        return advertiserService.getAdvertiser(id);
    }

    @RequestMapping(value = "/api/advertiser/check-credit",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkAdvertiserCredit(@RequestParam("id") Integer id, @RequestParam("amount") Integer amount) {
        return advertiserService.checkAdvertiserCredit(id, amount);
    }
}
