package com.bailemos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BailemosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BailemosApplication.class, args);
	}

}
