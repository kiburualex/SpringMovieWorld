/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclectics.movieworld.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Tag;

/**
 *
 * @author kiburu
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
            .select()                                  
            .apis(RequestHandlerSelectors.basePackage("com.eclectics"))
            .paths(PathSelectors.any())                          
            .build()
            .apiInfo(metadata())//
            .useDefaultResponseMessages(false)//
            .securitySchemes(Collections.singletonList(apiKey()))
            .securityContexts(Collections.singletonList(securityContext()))
            .tags(new Tag("users", "Operations about users"))//
            .genericModelSubstitutes(Optional.class);                                         
    }
    
    private ApiInfo metadata() {
        return new ApiInfoBuilder()//
            .title("MovieWorld API")//
            .description("Sample Api using JWT")//
            .version("1.0.0")//
            .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
            .contact(new Contact(null, null, "alexkiburu@gmail.com"))//
            .build();
      }

      private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
      }

      private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.any())
            .build();
    }
      
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything") {};
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }
  
}
