package com.employeeservice.config;

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
public class EmployeeSwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/employee-service/employee.*"), regex("/employee-service/department.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("EmployeeService API")
				.description("Employee service for maintaing employee and department records. Also we can perform crud opertaion on the same")
				.termsOfServiceUrl("http://localhost:8080")
				.license("")
				.licenseUrl("vignesh@gmail.com").version("1.0").build();
	}

}
