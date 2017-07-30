package com.rollingstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SuppressWarnings("deprecation")
@EnableAutoConfiguration // Sprint Boot Automatic Configuration
@ComponentScan(basePackages = "com.rollingstone")
@EnableJpaRepositories("com.rollingstone.dao.jpa") // To segregate MongoDB and JPA repositories. Otherwise not needed.
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
public class SpringBootMicroserviceStarterTemplateTODOChangeThisToYourApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceStarterTemplateTODOChangeThisToYourApp.class, args);
	}
}
