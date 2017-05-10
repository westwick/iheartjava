package com.iheart.web;

import com.iheart.model.Advertiser;
import com.iheart.service.AdvertiserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Create a new advertiser", notes = "must specify advertiserName, contactName, and creditLimit")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    @RequestMapping(value = "/api/advertiser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAdvertiser(@RequestBody Advertiser advertiser) {
        advertiserService.createAdvertiser(advertiser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "Update an existing advertiser", notes = "Must specify advertiser ID to update")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    @RequestMapping(value = "/api/advertiser", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAdvertiser(@RequestBody Advertiser advertiser) {
        if (validateAdvertiserId(advertiser)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        advertiserService.updateAdvertiser(advertiser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "Delete an advertiser")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    @RequestMapping(value = "/api/advertiser", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAdvertiser(@RequestBody Advertiser advertiser) {
        if (validateAdvertiserId(advertiser)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        advertiserService.deleteAdvertiser(advertiser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "Get advertiser details", notes = "Must specify advertiser ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success")
    })
    @RequestMapping(value = "/api/advertiser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAdvertiser(@RequestParam("id") Integer id) {
        Advertiser advertiser = advertiserService.getAdvertiser(id);
        if (advertiser != null) {
            return ResponseEntity.accepted().body(advertiser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Check advertiser credit", notes = "Must specify advertiser ID and credit amount to check")
    @RequestMapping(value = "/api/advertiser/check-credit",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkAdvertiserCredit(@RequestParam("id") Integer id, @RequestParam("amount") Integer amount) {
        return advertiserService.checkAdvertiserCredit(id, amount);
    }

    private boolean validateAdvertiserId(@RequestBody Advertiser advertiser) {
        return advertiser.getId() == null;
    }
}
