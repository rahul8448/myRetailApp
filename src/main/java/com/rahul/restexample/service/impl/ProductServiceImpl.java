package com.rahul.restexample.service.impl;


import com.rahul.restexample.entity.nosql.CurrentPrice;
import com.rahul.restexample.entity.nosql.Products;
import com.rahul.restexample.model.productdescription.Product;
import com.rahul.restexample.model.productdescription.Response;
import com.rahul.restexample.model.request.Price;
import com.rahul.restexample.model.response.ProductInfo;
import com.rahul.restexample.repository.ProductInfoRepository;
import com.rahul.restexample.service.ProductService;
import com.rahul.restexample.utility.ProductUtility;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ProductServiceImpl implements ProductService
{

  @Autowired
  private ProductInfoRepository productInfoRepository;

  @Autowired
  private ProductUtility productUtility;


  @Override
  public ProductInfo getProductById(Long id)
  {

    //Getting product cost
    Products product=productInfoRepository.findOne(id);

    //Getting product description
    Response response=productUtility.getProductDescription(id);

    ProductInfo productInfo=new ProductInfo();
    productInfo.setProductId(Long.toString(id));
    productInfo.setProductDescription(response.getProduct().getItem().getProductDescription().getGeneralDesc());
    productInfo.setProductPrice(product.currentPrice.price.toString());
    productInfo.setProductCurrency(product.currentPrice.currencyCode);

    return  productInfo;
  }

  @Override
  public ProductInfo updateProductPrice(Long prodId,Price price) {


    //Check if the product exists in database
    Products product=productInfoRepository.findOne(prodId);

     //Check if new Price and old price are same.


    if(product!=null)
    {
      //Update the product
      CurrentPrice currentPrice=product.getCurrentPrice();
      currentPrice.setPrice(new Decimal128(new BigDecimal(price.getNewPrice())));
      product.setCurrentPrice(currentPrice);
      product=productInfoRepository.save(product);
      Response response=productUtility.getProductDescription(prodId);
      ProductInfo productInfo=new ProductInfo();
      productInfo.setProductId(Long.toString(product.getId()));
      productInfo.setProductDescription(response.getProduct().getItem().getProductDescription().getGeneralDesc());
      productInfo.setProductPrice(product.currentPrice.price.toString());
      productInfo.setProductCurrency(product.currentPrice.currencyCode);
      productInfo.setProductPrice(product.getCurrentPrice().getPrice().toString());
      return  productInfo;
    }
    else
    {
        return null;
    }
  }
}
