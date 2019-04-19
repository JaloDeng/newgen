package com.newgen.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.newgen.result.Result;

@RestControllerAdvice
public class BadRequestExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(BadRequestExceptionHandler.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) throws Exception {
		BindingResult result = exception.getBindingResult();
		List<Map<String, String>> defaultMessages = new ArrayList<>();
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(p -> {
				FieldError fieldError = (FieldError) p;
				Map<String, String> map = new HashMap<>();
				map.put("field", fieldError.getField());
				map.put("message", fieldError.getDefaultMessage());
				defaultMessages.add(map);
			});
		}
		LOGGER.error(defaultMessages.toString());
		return new Result(0, "请填写正确信息", defaultMessages);
	}
}
