//package com.airport.swagger;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class CorsConfig implements  WebMvcConfigurer{
////	@Value("${allowed.origin}")
////	private String allowedOrigin;
////	@Bean
////	public WebMvcConfigurer configure() {
////		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedMethods("POST","PUT","DELETE").allowedHeaders("*")
//				.allowedOrigins("*");
//			}
//	//	};
//	}
