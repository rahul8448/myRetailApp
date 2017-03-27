package com.rahul.restexample.service;


import com.rahul.restexample.entity.nosql.Products;
import com.rahul.restexample.model.request.Price;
import com.rahul.restexample.model.response.ProductInfo;

public interface ProductService
{

  /**
   * This method gets product description based on id.
   * @param id
   * @return
   */
  ProductInfo getProductById(Long id);

  /**
   * This method updates product price.
   * @param prodId
   * @param price
   * @return
   */
  ProductInfo updateProductPrice(Long prodId,Price price);

}
