package com.polytech;

import com.polytech.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "DEV");
		SpringApplication.run(DemoApplication.class, args);
	}
}
