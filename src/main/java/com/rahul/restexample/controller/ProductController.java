package com.rahul.restexample.controller;


import com.rahul.restexample.entity.nosql.Products;
import com.rahul.restexample.exceptions.InvalidParamException;
import com.rahul.restexample.exceptions.NoDataFoundException;
import com.rahul.restexample.exceptions.ServerException;
import com.rahul.restexample.model.request.Price;
import com.rahul.restexample.model.response.ProductInfo;
import com.rahul.restexample.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This is the Rest controller class which has the required end points.
 */
@RestController
@RequestMapping(value = "/v1/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "/v1/products", description = "The myRetailApp Restful API", consumes="application/json")
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
    @ApiOperation(value = "Retrieve product details for the specified id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The product id found"),
            @ApiResponse(code = 204 , message = "The product id not found."),
            @ApiResponse(code = 400 , message = "The params supplied is not valid"),
            @ApiResponse(code = 500, message = "Server Error")
    })
    private ResponseEntity<ProductInfo> getProductById(@PathVariable("productId") Long productId) throws NoDataFoundException,ServerException,InvalidParamException {

        logger.info("Getting details of product id:" + productId);
        ProductInfo productInfo= productService.getProductById(productId);
        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }

    /**
     * This method updates pricing details for each
     * @param productId
     * @param price
     * @return
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update product price for the specified id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message = "The product detail has been updated"),
            @ApiResponse(code = 204, message = "The product id not found."),
            @ApiResponse(code = 400 , message = "The params supplied is not valid"),
            @ApiResponse(code = 500, message = "Server Error")
    })
    private ResponseEntity<ProductInfo> updatePrice(@PathVariable("productId") Long productId,@RequestBody Price price) throws NoDataFoundException,ServerException,InvalidParamException{

        logger.info("Updating product id:" + productId);
        ProductInfo productInfo=productService.updateProductPrice(productId,price);
        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }

}
