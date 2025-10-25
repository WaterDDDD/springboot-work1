package com.kai.springbootwork1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootWork1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWork1Application.class, args);
	}

}
