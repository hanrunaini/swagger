package com.srr.controller;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .version("1.1")
                .description("北京上学堂的配置文件")
                .title("我的第一个配置文件哈哈")
                .contact(new Contact("srr", "http://www.bjsxt.com", "admin@bjsxt.com"))
                .build();
        docket.apiInfo(apiInfo).groupName("我的第一个分组")
                .select()
                .apis(Predicates.not(
                        RequestHandlerSelectors.withMethodAnnotation(MyAnnotation$Swagger.class)
                ))
                .apis(RequestHandlerSelectors.basePackage("com.srr.controller"))
                .paths(
                        PathSelectors.regex("/swagger/.*")
                )
                .build();


        return docket;
    }
}
