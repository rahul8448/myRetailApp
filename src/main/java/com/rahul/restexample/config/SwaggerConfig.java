package com.rahul.restexample.config;

/**
 * Created by rsharma on 3/23/2017.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is a configuration class for Swagger related configuration.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2).enable(true).select().apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error"))).build();
    }

}