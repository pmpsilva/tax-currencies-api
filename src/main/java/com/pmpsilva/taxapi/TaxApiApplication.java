package com.pmpsilva.taxapi;

import com.pmpsilva.taxapi.app.error.MyExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

@SpringBootApplication
public class TaxApiApplication {

	@Bean
	HandlerExceptionResolver customExceptionResolver () {
		return new MyExceptionHandler();
	}
	public static void main(String[] args) {
		SpringApplication.run(TaxApiApplication.class, args);
	}

}
