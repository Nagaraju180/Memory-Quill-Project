package com.ynr.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MyDairyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDairyAppApplication.class, args);
		System.out.println("Server started run the application on browser");
	}

}
