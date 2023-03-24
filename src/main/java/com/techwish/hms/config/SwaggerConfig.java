package com.techwish.hms.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket configureDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.techwish.hms.rest"))
				.paths(PathSelectors.regex("/v1/api.*"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"HMS APPLICATION", 
				"Developed By SAMPLE Team", 
				"3.2GA", "http://sample.com", 
				new Contact("RAGHU", "http://sample.com/raghu", 
						"javabyraghu@gmail.com"), 
				"Apache", "http://test.com", 
				Collections.emptyList());
	}
}
