package com.rahul.restexample.entity.nosql;

import org.bson.types.Decimal128;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * Created by rsharma on 3/23/2017.
 */

public class CurrentPrice {

    @Field(value = "value")
    public Decimal128 price;

    @Field(value = "currency_code")
    public String currencyCode;

    public CurrentPrice(){
        super();
    }
    public CurrentPrice(Decimal128 currentPrice, String currencyCode) {
        this.price = currentPrice;
        this.currencyCode = currencyCode;
    }

    public Decimal128 getPrice() {
        return price;
    }

    public void setPrice(Decimal128 price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "CurrentPrice{" +
                "currentPrice=" + price +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
