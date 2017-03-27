package com.rahul.restexample.model.request;

import java.io.Serializable;

/**
 * Created by rahulsharma on 3/26/17.
 */
public class Price implements Serializable
{
    private String newPrice;

    public Price(){

    }

    public Price(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }
}
