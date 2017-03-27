package com.rahul.restexample.utility;

import com.rahul.restexample.model.productdescription.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by rsharma on 3/23/2017.
 */
@Component
public class ProductUtility
{

    final static Logger logger = Logger.getLogger(ProductUtility.class);

    @Value("${product.description.url}")
    private String productURL;

    @Value("${product.description.params}")
    private String queryParams;

    /**
     * This method retrives the product description for a particular product id from the external url.
     * @param id
     * @return
     */
    public Response getProductDescription(Long id)
    {
        logger.info("Entering the getProductDescription method");
        RestTemplate restTemplate = new RestTemplate();
        String finalUrl=productURL+"/"+id+"?"+queryParams;
        Response response = null;
        response = restTemplate.getForObject(finalUrl, Response.class);
        logger.info(response.toString());
        logger.info("Exiting the getProductDescription method");
        return response;
    }
}
