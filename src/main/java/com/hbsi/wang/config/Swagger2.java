package com.hbsi.wang.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configurable
public class Swagger2 {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))//扫描com路径下的api文档
                .paths(PathSelectors.any())//路径判断
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger 开发规范")//标题
                .description("Saggger 开发规范详文档细地址--->>>>>>>：http://www.google.com.hk")//描述
                .termsOfServiceUrl("www.baidu.com")
                .version("6.6.6")//版本号
                .build();
    }
}
