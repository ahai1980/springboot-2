package com.ora;

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
import com.ora.model.User;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     *
     * @Bean public Docket testApi() {
     * return new Docket(DocumentationType.SWAGGER_2)
     * .apiInfo(apiInfo()).ignoredParameterTypes(User.class)
     * .select()
     * .apis(RequestHandlerSelectors.basePackage("com.ora"))
     * .paths(PathSelectors.any())
     * .build();
     * }
     * <p>
     * <p>
     * <p>
     * private ApiInfo apiInfo() {
     * ApiInfo apiInfo = new ApiInfo("SpringBoot学习demo",//大标题
     * "Spring boot + swagger + mybatis + druid",//小标题
     * "1.0",//版本
     * "NO terms of service",
     * new Contact("jetora","https://github.com/jetora","jetoralook@outlook.com"),//作者
     * "RayeBlog",//链接显示文字
     * "http://www.raye.wang/"//网站链接
     * );
     * <p>
     * return apiInfo;
     * }
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ora"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("SpringBoot学习demo",//大标题
                "Spring boot + swagger + mybatis + druid",//小标题
                "1.0",//版本
                "NO terms of service",
                new Contact("jetora", "https://github.com/jetora", "jetoralook@outlook.com"),//作者
                "RayeBlog",//链接显示文字
                "http://www.raye.wang/"//网站链接
        );
        return apiInfo;
    }
}