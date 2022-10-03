package com.digitalbooks.login.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.digitalbooks.login"})
@Configuration
@EnableJpaRepositories
@EnableEurekaClient
@EnableSwagger2
public class SpringBootCrudOperationApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}
}
