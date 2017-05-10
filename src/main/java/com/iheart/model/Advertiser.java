package com.iheart.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Andrew on 5/9/2017.
 */
@Data
public class Advertiser implements Serializable {

    private Long id;
    private String advertiserName;
    private String contactName;
    private Integer creditLimit;

    public boolean hasSufficientCredit(Integer amount) {
        if(amount == null) {
            throw new IllegalArgumentException("amount must be integer");
        }
        return amount <= this.creditLimit;
    }

}
