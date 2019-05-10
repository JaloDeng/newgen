package com.newgen.backmanager.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.commons.model.Result;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-10 09:07
 */

@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		Result result = new Result(0, "权限不足，请联系管理员！", null);
		printWriter.write(new ObjectMapper().writeValueAsString(result));
		printWriter.flush();
		printWriter.close();
	}

}
