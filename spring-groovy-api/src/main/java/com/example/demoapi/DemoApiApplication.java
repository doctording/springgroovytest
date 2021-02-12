package com.example.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}
}
