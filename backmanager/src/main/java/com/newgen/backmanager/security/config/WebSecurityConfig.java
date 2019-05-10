package com.newgen.backmanager.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.backmanager.service.ActivityUserService;
import com.newgen.commons.model.Result;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-10 09:20
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ActivityUserService activityUserService;
	
	@Autowired
	private CustomMetadataSource customMetadataSource;
	
	@Autowired
	private UrlAccessDecisionManager urlAccessDecisionManager;
	
	@Autowired
	private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(activityUserService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/index.html", "/static/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(O object) {
						object.setSecurityMetadataSource(customMetadataSource);
						object.setAccessDecisionManager(urlAccessDecisionManager);
						return object;
					}
				})
				.and()
				.formLogin()
					.loginPage("/login_p")
					.loginProcessingUrl("/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.failureHandler(new AuthenticationFailureHandler() {
						@Override
						public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
								AuthenticationException exception) throws IOException, ServletException {
							response.setContentType("application/json;charset=utf-8");
							Result result = null;
							if (exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException) {
								result = new Result(0, "用户名或密码错误！", null);
							} else if (exception instanceof LockedException) {
								result = new Result(0, "用户被锁定，请联系管理员！", null);
							} else if (exception instanceof CredentialsExpiredException) {
								result = new Result(0, "密码过期，请联系管理员！", null);
							} else if (exception instanceof AccountExpiredException) {
								result = new Result(0, "用户过期，请联系管理员！", null);
							} else if (exception instanceof DisabledException) {
								result = new Result(0, "用户被禁用，请联系管理员！", null);
							} else {
								result = new Result(0, "登陆失败", null);
							}
							response.setStatus(401);
							ObjectMapper om = new ObjectMapper();
							PrintWriter pw = response.getWriter();
							pw.write(om.writeValueAsString(result));
							pw.flush();
							pw.close();
						}
					})
					.successHandler(new AuthenticationSuccessHandler() {
						@Override
						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
								Authentication authentication) throws IOException, ServletException {
							response.setContentType("application/json;charset=utf-8");
							Result result = new Result(1, "登陆成功", null);
							ObjectMapper om = new ObjectMapper();
							PrintWriter pw = response.getWriter();
							pw.write(om.writeValueAsString(result));
							pw.flush();
							pw.close();
						}
					})
					.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessHandler(new LogoutSuccessHandler() {
						@Override
						public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
								throws IOException, ServletException {
							response.setContentType("application/json;charset=utf-8");
							Result result = new Result(1, "注销成功", null);
							ObjectMapper om = new ObjectMapper();
							PrintWriter pw = response.getWriter();
							pw.write(om.writeValueAsString(result));
							pw.flush();
							pw.close();
						}
					})
					.permitAll()
				.and()
				.csrf()
					.disable()
					.exceptionHandling()
					.accessDeniedHandler(authenticationAccessDeniedHandler);
	}
}
