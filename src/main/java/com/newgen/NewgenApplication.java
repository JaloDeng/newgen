package com.newgen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@SpringBootApplication
@MapperScan("com.newgen.mapper")
public class NewgenApplication {

	@Bean
	public ServletRegistrationBean<DispatcherServlet> servletRegistrationBean(DispatcherServlet dispatcherServlet) {
		return new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet, "*.do", "/");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NewgenApplication.class, args);
	}

}
