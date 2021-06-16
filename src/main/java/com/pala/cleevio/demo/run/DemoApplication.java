package com.pala.cleevio.demo.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class of this app.
 */
@SpringBootApplication
@EnableJpaRepositories("com.pala.cleevio.demo.dao")
@ComponentScan(basePackages = { "com.pala.cleevio.demo.*" })
@EntityScan("com.pala.cleevio.demo.dao.entity")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
