package com.demo.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger2.enabled}")
    private boolean enable;

    @Value("${swagger2.title}")
    private String title;

    @Value("${swagger2.description}")
    private String description;

    @Value("${swagger2.version}")
    private String version;

    @Value("${swagger2.contact.name}")
    private String contactName;

    @Value("${swagger2.basePackage}")
    private String basePackage;

    @Value("${swagger2.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    @Bean("AuthApis")
    public Docket AuthApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户权限申请与认证模块")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/auth.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

    @Bean("BookApis")
    public Docket BookApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("书籍模块")
                .select()
//                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/book.*"))
//                .paths(PathSelectors.any())
                .build()
//                .securitySchemes(newArrayList(apiKey())) // 不管用
//                .securityContexts(securityContexts())
                .globalOperationParameters(setHeaderToken())
                .apiInfo(apiInfo())
                .enable(enable);
    }



    private ApiInfo apiInfo() {
        Contact contact = new Contact(contactName, "", "");
        System.out.println(contact);

        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .version(version)
                .contact(contact)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
//
//    private List<SecurityContext> securityContexts() {
//        return newArrayList(
//                SecurityContext.builder()
//                        .securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                        .build()
//        );
//    }
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return newArrayList(
//                new SecurityReference("Authorization", authorizationScopes));
//    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("用户认证Token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

}
