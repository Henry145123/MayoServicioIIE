package com.idat.MayoServicioPrueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.idat.MayoServicioPrueba.controller","com.idat.MayoServicioPrueba.repository","com.idat.MayoServicioPrueba.model","com.idat.MayoServicioPrueba.service","com.idat.MayoServicioPrueba.security"})
@PropertySource("classpath:application.properties")
public class MayoServicioPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MayoServicioPruebaApplication.class, args);
	}

}
