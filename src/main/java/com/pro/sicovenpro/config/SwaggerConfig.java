package com.pro.sicovenpro.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ConditionalOnExpression("${swagger.enable}")
public class SwaggerConfig{
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
    //            .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pro.sicovenpro"))
                .paths(PathSelectors.any())
                .build();
    }
}