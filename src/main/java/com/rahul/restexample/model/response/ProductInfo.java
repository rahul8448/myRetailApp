package com.rahul.restexample.model.response;

/**
 * Created by rahulsharma on 3/25/17.
 */
public class ProductInfo
{
    private String productId;
    private String productDescription;
    private String productPrice;
    private String productCurrencyCode;



    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCurrency() {
        return productCurrencyCode;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrencyCode = productCurrency;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productCurrency='" + productCurrencyCode + '\'' +
                '}';
    }
}
