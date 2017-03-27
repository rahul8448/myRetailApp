package com.rahul.restexample.repository;


import com.rahul.restexample.entity.nosql.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rsharma on 3/23/2017.
 */
@Repository
public interface ProductInfoRepository extends MongoRepository<Products, Long> {

}
