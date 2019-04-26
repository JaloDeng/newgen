package com.newgen.backmanager.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.commons.model.Result;
import com.newgen.commons.service.ActivitySponsorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-26 10:08
 */

@Api(value = "ActivityController", tags = {"活动模块"})
@Controller
public class ActivityController {

	@Autowired
	private ActivitySponsorService activitySponsorService;
	
	@ApiOperation("获取活动主办方列表")
	@RequestMapping(value = { "/getActivitySponsorList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivitySponsorList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(1, null, activitySponsorService.findList(params));
	}
}
