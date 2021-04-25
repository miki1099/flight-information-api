package com.example.flightapi.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringfoxDocket() {
        Contact contact = new Contact(
                "Michał Głodek",
                "https://github.com/miki1099/learning-application-with-shop",
                "miki.glodek@wp.pl");

        List<VendorExtension> vext = new ArrayList<>();
        ApiInfo apiInfo = new ApiInfo(
                "recruitment task API",
                "",
                "0.0.1",
                "",
                contact,
                "",
                "",
                vext);

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

