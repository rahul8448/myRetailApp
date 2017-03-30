package com.rahul.restexample.service;


import com.rahul.restexample.entity.nosql.Products;
import com.rahul.restexample.exceptions.InvalidParamException;
import com.rahul.restexample.exceptions.NoDataFoundException;
import com.rahul.restexample.exceptions.ServerException;
import com.rahul.restexample.model.request.Price;
import com.rahul.restexample.model.response.ProductInfo;

public interface ProductService
{

  /**
   * This method gets product description based on id.
   * @param id
   * @return
   */
  ProductInfo getProductById(Long id) throws NoDataFoundException,ServerException;

  /**
   * This method updates product price.
   * @param prodId
   * @param price
   * @return
   */
  ProductInfo updateProductPrice(Long prodId,Price price) throws NoDataFoundException,ServerException,InvalidParamException;

}
