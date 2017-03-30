package com.rahul.restexample.service.impl;


import com.rahul.restexample.entity.nosql.CurrentPrice;
import com.rahul.restexample.entity.nosql.Products;
import com.rahul.restexample.exceptions.InvalidParamException;
import com.rahul.restexample.exceptions.NoDataFoundException;
import com.rahul.restexample.exceptions.ServerException;
import com.rahul.restexample.model.productdescription.Product;
import com.rahul.restexample.model.productdescription.Response;
import com.rahul.restexample.model.request.Price;
import com.rahul.restexample.model.response.ProductInfo;
import com.rahul.restexample.repository.ProductInfoRepository;
import com.rahul.restexample.service.ProductService;
import com.rahul.restexample.utility.ProductUtility;
import org.apache.log4j.Logger;
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

  final static Logger logger = Logger.getLogger(ProductServiceImpl.class);

  @Override
  public ProductInfo getProductById(Long id) throws NoDataFoundException,ServerException
  {

    logger.info("Entering the getProductById method");
    //Getting product cost
    Products product=productInfoRepository.findOne(id);
    if(product==null)
      throw new NoDataFoundException("There is no pricing data for the id:"+id);

    //Getting product description
    Response response=productUtility.getProductDescription(id);
    if(response==null)
      throw new NoDataFoundException("There is product description data for the id:"+id);

    ProductInfo productInfo=new ProductInfo();
    productInfo.setProductId(Long.toString(id));
    if(response.getProduct()!=null && response.getProduct().getItem()!=null && response.getProduct().getItem().getProductDescription()!=null && response.getProduct().getItem().getProductDescription().getGeneralDesc()!=null)
        productInfo.setProductDescription(response.getProduct().getItem().getProductDescription().getGeneralDesc());
    else
      throw new NoDataFoundException("The product info for the particlar id does not have enough data to detremine price");

    productInfo.setProductPrice(product.currentPrice.price.toString());
    productInfo.setProductCurrency(product.currentPrice.currencyCode);

    logger.info("Exiting the getProductById method");
    return  productInfo;
  }

  @Override
  public ProductInfo updateProductPrice(Long prodId,Price price) throws NoDataFoundException,ServerException,InvalidParamException
  {

    logger.info("Entering the updateProductPrice method");

    //Check if the product exists in database
    Products product=productInfoRepository.findOne(prodId);
    if(product==null)
      throw new NoDataFoundException("There is no pricing data for the id:"+prodId);

      CurrentPrice currentPrice=product.getCurrentPrice();

     //Check if  price is numericvalue
      try
      {
        currentPrice.setPrice(new Decimal128(new BigDecimal(price.getNewPrice())));
      }
      catch (Exception ex)
      {
        throw  new InvalidParamException("The price value is not a number");
      }
      product.setCurrentPrice(currentPrice);
      //Update the product
      product=productInfoRepository.save(product);
      Response response=productUtility.getProductDescription(prodId);
      ProductInfo productInfo=new ProductInfo();
      productInfo.setProductId(Long.toString(product.getId()));
      if(response.getProduct()!=null && response.getProduct().getItem()!=null && response.getProduct().getItem().getProductDescription()!=null && response.getProduct().getItem().getProductDescription().getGeneralDesc()!=null)
        productInfo.setProductDescription(response.getProduct().getItem().getProductDescription().getGeneralDesc());
      else
        throw new NoDataFoundException("The product info for the particlar id does not have enough data to detremine price");
      productInfo.setProductPrice(product.currentPrice.price.toString());
      productInfo.setProductCurrency(product.currentPrice.currencyCode);
      productInfo.setProductPrice(product.getCurrentPrice().getPrice().toString());
      logger.info("Exiting the updateProductPrice method");
      return  productInfo;

  }
}
