package com.newgen.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 10:00
 */

@Configuration
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("佛山+ APP API文档")
						.description("备注")
						.version("1.0")
						.build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.newgen"))
				.paths(PathSelectors.any())
				.build();
	}
}
