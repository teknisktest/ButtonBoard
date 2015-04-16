package com.soprasteria.boot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.*;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BootUp {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootUp.class, args);
	}
	
	public static String tekniskTest(String input) {
		if (input == "teknisk test") {
			return "FUN FUN FUN";
		} else {
			return "YEAH YEAH";
		}
	}
		

}

