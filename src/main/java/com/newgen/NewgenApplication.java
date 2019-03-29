package com.newgen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan("com.newgen.mapper")
public class NewgenApplication {

	@Bean
	public ServletRegistrationBean<DispatcherServlet> servletRegistrationBean(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean<DispatcherServlet> bean = new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet, "*.do", "/");
		return bean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NewgenApplication.class, args);
	}

}
