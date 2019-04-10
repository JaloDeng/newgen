package com.newgen.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.service.ActivityService;
import com.newgen.service.ActivitySignUpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api(value = "ActivityController", tags = {"活动模块"})
public class ActivityController extends BaseController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private ActivitySignUpService activitySignUpService;
	
	@ApiOperation("根据活动ID获取活动详细信息")
	@GetMapping(value = { "/getActivityById" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> getActivityById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return result(1, null, activityService.queryById(id));
	}
	
	@ApiOperation("获取活动列表")
	@GetMapping(value = { "/getActivityList" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> findList(@RequestParam(required = false) @ApiParam("页码") Integer page,
			@RequestParam(required = false) @ApiParam("行数") Integer row, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return result(1, null, activityService.findListForSearch(page, row));
	}
	
}
