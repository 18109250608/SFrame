package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


//    @Bean("BookApis")
    @Bean
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("书籍模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/book.*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .enable(enable);
    }

//    @Bean("CustomApis")
//    public Docket customApis() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("客户模块")
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.regex("/custom.*"))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enable);
//    }

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


}
