package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(DemoApplication.class, args);
		
		System.out.println("first spring project");
	}
	
		/**
		 * Enables CORS to all urls
		 * 
		 * @return
		 */
		@Bean
		public WebMvcConfigurer corsConfigurer() {

			WebMvcConfigurer w = new WebMvcConfigurer() {

				/**
				 * Add CORS
				 */
				public void addCorsMappings(CorsRegistry registry) {
					CorsRegistration cors = registry.addMapping("/**");
					cors.allowedOrigins("http://localhost:4200");
					cors.allowedHeaders("*");
					cors.allowCredentials(true);
				}
	

	
};
return w;
		}
	}