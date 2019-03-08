package com.thadocizn.shopping_cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.thadocizn.shopping_cart"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointInfo());
    }







    private ApiInfo apiEndPointInfo() {

        return new ApiInfoBuilder().title("Shopping Cart")
                .description("Todo App")
                .contact(new Contact("Charles Johnson", "https://www.linkedin.com/in/charles-johnson-a9666913/", "charles.tha.doc@gmail.com"))
                .license("MIT")
                .licenseUrl("https://github.com/LambdaSchool/java-crudysnacks/blob/master/LICENSE")
                .version("1.0.0")
                .build();
    }

}