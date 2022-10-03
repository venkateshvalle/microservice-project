package com.digitalbooks.login.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/v1/digitalBooks/books.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Book Service API")
				.description("Book Service API for developers")
				.termsOfServiceUrl("http://localhost:8092/book-service/")
				.contact("puramsetty.surendra@cognizant.com").license("JavaInUse License")
				.licenseUrl("puramsetty.surendra@cognizant.com").version("1.0").build();
	}

}
