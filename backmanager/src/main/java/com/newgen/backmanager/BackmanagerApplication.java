package com.newgen.backmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019-04-25 10:38:59
 */

@ComponentScan(basePackages = "com.newgen")
@EnableSwagger2
@MapperScan({"com.newgen.backmanager.mapper", "com.newgen.commons.mapper"})
@SpringBootApplication
public class BackmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackmanagerApplication.class, args);
	}

}
