package com.rahul.restexample.model.productdescription;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rahulsharma on 3/25/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item
{
    @JsonProperty("product_description")
    private ProductDescription productDescription;

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }
}
