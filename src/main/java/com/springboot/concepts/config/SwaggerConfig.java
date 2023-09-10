package com.springboot.concepts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;
import java.util.List;


/*
 * @Configuration:
The @Configuration annotation is used to indicate that a class provides bean configurations. 
It's typically used on classes that define one or more @Bean methods. 
These methods are responsible for instantiating, configuring, and
returning beans that will be managed by the Spring IoC (Inversion of Control) container.
In this context, @Configuration indicates that the class 
(SwaggerConfig) contains bean definitions for Swagger configuration.
@EnableSwagger2:

@EnableSwagger2 is a specific annotation provided by the springfox library, 
which integrates Swagger with Spring applications. When placed on a class, it
 triggers the configuration of Swagger to be activated in your application.
This annotation enables the generation of Swagger documentation and the 
Swagger UI for API documentation.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // This method creates a Docket bean which is the main configuration of Swagger.
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // Select all request handlers
                .build() 
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()));
    }

    // This method defines an API key that will be used for authorization.
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    // This method defines the security context. 
    // It specifies the security schemes and the paths they apply to.
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth()) // Specify the security references
                .build();
    }

    // This method defines the default security references for the API.
    private List<SecurityReference> defaultAuth() {
        return Collections.singletonList(new SecurityReference("Authorization", new AuthorizationScope[0]));
    }
}

