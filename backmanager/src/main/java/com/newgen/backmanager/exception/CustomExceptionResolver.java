package com.newgen.backmanager.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-14 14:55
 */

public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", 0);
		map.put("msg", ex.getMessage());
		map.put("data", null);
		mv.addAllObjects(map);
		return mv;
	}

}
