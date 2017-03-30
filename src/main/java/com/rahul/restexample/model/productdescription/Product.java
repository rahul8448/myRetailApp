package com.rahul.restexample.model.productdescription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rahulsharma on 3/25/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product
{
  @JsonProperty("item")
  private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
