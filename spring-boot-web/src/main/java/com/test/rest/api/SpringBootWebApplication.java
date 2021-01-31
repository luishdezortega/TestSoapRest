package com.test.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfo("API CLIENTE",
                "Documentacion de las Apis Rest para operaciones con informacion del empleado", "1.0",
                "Términos y Condiciones",
                new Contact("Desarrollador", "Ingeniero de Sitemas", "luis.hernandez@pragma.com.co"), "License", "",
                Collections.emptyList());
    }

}
