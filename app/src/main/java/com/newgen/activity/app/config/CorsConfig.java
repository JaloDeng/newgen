package com.newgen.activity.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer  {

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
			.allowCredentials(true)
			.maxAge(3600);
	}
}
