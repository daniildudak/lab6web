package com.example.labsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

@SpringBootApplication
public class LabsoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsoapApplication.class, args);
	}

}
