package com.newgen.backmanager.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.commons.bean.Activity;
import com.newgen.commons.bean.ActivitySponsor;
import com.newgen.commons.model.Result;
import com.newgen.commons.service.ActivityReviewService;
import com.newgen.commons.service.ActivityService;
import com.newgen.commons.service.ActivitySignUpService;
import com.newgen.commons.service.ActivitySponsorService;
import com.newgen.commons.util.StringUtil;

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
	private ActivityService activityService;
	
	@Autowired
	private ActivitySignUpService activitySignUpService;
	
	@Autowired
	private ActivitySponsorService activitySponsorService;
	
	@Autowired
	private ActivityReviewService activityReviewService;
	
	@ApiOperation("根据ID获取活动详细信息")
	@RequestMapping(value = { "/getActivityById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivityById(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityService.queryById(id));
	}
	
	@ApiOperation("获取活动列表")
	@RequestMapping(value = { "/getActivityList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivityList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityService.findList(params));
	}
	
	@ApiOperation("根据ID获取报名信息")
	@RequestMapping(value = { "/getActivitySignUpById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivitySignUpById(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activitySignUpService.queryById(id));
	}
	
	@ApiOperation("获取活动报名信息列表")
	@RequestMapping(value = { "/getActivitySignUpList" }, produces = { "application/json;charset=UTF-8" }, 
	method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivitySignUpList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activitySignUpService.findList(params));
	}
	
	@ApiOperation("获取活动主办方列表")
	@RequestMapping(value = { "/getActivitySponsorList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivitySponsorList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new Result(1, null, activitySponsorService.findList(params));
	}
	
	@ApiOperation("根据ID获取活动主办方信息")
	@RequestMapping(value = { "/getActivitySponsorById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivitySponsorById(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activitySponsorService.queryById(id));
	}
	
	@ApiOperation("获取活动评价列表")
	@RequestMapping(value = { "/getActivityReviewList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivityReviewList(@RequestBody Map<String, Object> params, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new Result(1, null, activityReviewService.findList(params));
	}
	
	@ApiOperation("根据ID获取活动评价信息")
	@RequestMapping(value = { "/getActivityReviewById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivityReviewById(@RequestParam String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityReviewService.queryById(id));
	}
	
	@ApiOperation("保存活动主办方")
	@RequestMapping(value = { "/saveActivitySponsor" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result saveActivitySponsor(@Valid @RequestBody ActivitySponsor activitySponsor, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return activitySponsorService.save(activitySponsor);
	}
	
	@ApiOperation("保存活动")
	@RequestMapping(value = { "/saveActivity" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result saveActivity(@Valid @RequestBody Activity activity, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return activityService.save(activity);
	}
	
	@ApiOperation("测试dateId")
	@RequestMapping(value = { "/getDateId" }, produces = { "application/json;charset=UTF-8" }, method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String getDateId(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return StringUtil.getDateId();
	}
}
