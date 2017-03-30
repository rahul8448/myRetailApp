package com.rahul.restexample.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by rahulsharma on 3/25/17.
 * This is the Mongo DB configuration class.
 */
@Configuration
@EnableMongoRepositories("com.rahul.restexample.repository")
public class NoSQLConfiguration extends AbstractMongoConfiguration {


    @Value("${spring.data.mongodb.uri}")
    private String url;


    @Override
    protected String getDatabaseName() {
        return "myretaildb";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new MongoClientURI(url));
    }

}
