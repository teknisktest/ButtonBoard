package com.soprasteria.boot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BootUp {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootUp.class, args);
	}

}

