package com.rahul.restexample.entity.nosql;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



/**
 * Created by rsharma on 3/23/2017.
 */
@Document(collection="products")
public class Products {

    @Id
    public long id;

    @Field(value = "current_price")
    public CurrentPrice currentPrice;


    public Products(long id, CurrentPrice currentPrice) {
        this.id = id;
        this.currentPrice = currentPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "ProductCost{" +
                "id=" + id +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
