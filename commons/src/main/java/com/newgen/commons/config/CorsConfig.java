package com.newgen.commons.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 10:45
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
			.allowCredentials(true)
			.maxAge(3600);
	}
}
