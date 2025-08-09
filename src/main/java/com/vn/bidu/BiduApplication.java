package com.vn.bidu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BiduApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiduApplication.class, args);
	}

}
