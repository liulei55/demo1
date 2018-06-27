package com.liulei.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @EnableSwagger2 启用Swagger2
 * @Configuration 注解表示这个是一个配置文件，让spring来加载该类配置
 */
@EnableSwagger2
@Configuration
public class Swagger {

    @Bean
    public Docket restApi(){//创建api基本信息
        //apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
        //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，
        // Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liulei.springboot.web"))
                .paths(PathSelectors.any())
                .build();
        //apis 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外

    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springbootTest标题")
                .description("这是一个描述")
                .termsOfServiceUrl("终端服务程序")
                .contact("刘磊")
                .version("1.0.0")
                .build();
    }
}
