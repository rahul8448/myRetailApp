package com.rahul.restexample.controller;


import com.rahul.restexample.entity.nosql.Products;
import com.rahul.restexample.model.request.Price;
import com.rahul.restexample.model.response.ProductInfo;
import com.rahul.restexample.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * This is the Rest controller class which has the required end points.
 */
@RestController
@RequestMapping(value = "/v1/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

    final static Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * This method retrives details about each product based on product id.
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    private ProductInfo getProductById(@PathVariable("productId") Long productId) {

        logger.info("Getting details of product id:" + productId);
        return productService.getProductById(productId);
    }

    /**
     * This method updates pricing details for each
     * @param productId
     * @param price
     * @return
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    private ProductInfo updatePrice(@PathVariable("productId") Long productId,@RequestBody Price price) {

        logger.info("Updating product id:" + productId);
        return productService.updateProductPrice(productId,price);
    }

}
