package com.reader;

import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = {"com.reader"})
@EnableJpaRepositories
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
public class ReaderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderServiceApplication.class, args);
	}

}
