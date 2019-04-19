package com.newgen.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.bean.ActivityMemberLike;
import com.newgen.bean.ActivityReview;
import com.newgen.bean.ActivitySignUp;
import com.newgen.service.ActivityMemberLikeService;
import com.newgen.service.ActivityReviewService;
import com.newgen.service.ActivityService;
import com.newgen.service.ActivitySignUpService;
import com.newgen.service.ActivitySponsorService;
import com.newgen.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api(value = "ActivityController", tags = {"活动模块"})
public class ActivityController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private ActivitySignUpService activitySignUpService;
	
	@Autowired
	private ActivitySponsorService activitySponsorService;
	
	@Autowired
	private ActivityMemberLikeService activityMemberLikeService;
	
	@Autowired
	private ActivityReviewService activityReviewService;
	
	@ApiOperation("根据ID获取活动详细信息")
	@RequestMapping(value = { "/getActivityById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivityById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityService.queryById(id));
	}
	
	@ApiOperation("获取活动列表")
	@RequestMapping(value = { "/getActivityList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivityList(@RequestParam(required = false) @ApiParam("页码") Integer page,
			@RequestParam(required = false) @ApiParam("行数") Integer row, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("row", row);
		return new Result(1, null, activityService.findList(params));
	}
	
	@ApiOperation("根据ID获取报名信息")
	@RequestMapping(value = { "/getActivitySignUpById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivitySignUpById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activitySignUpService.queryById(id));
	}
	
	@ApiOperation("获取活动报名信息列表")
	@RequestMapping(value = { "/getActivitySignUpList" }, produces = { "application/json;charset=UTF-8" }, 
	method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivitySignUpList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activitySignUpService.findList(params));
	}
	
	@ApiOperation("获取活动主办方列表")
	@RequestMapping(value = { "/getActivitySponsorList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivitySponsorList(@RequestParam(required = false) @ApiParam("页码") Integer page,
			@RequestParam(required = false) @ApiParam("行数") Integer row, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("row", row);
		return new Result(1, null, activitySponsorService.findList(params));
	}
	
	@ApiOperation("根据ID获取活动主办方信息")
	@RequestMapping(value = { "/getActivitySponsorById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivitySponsorById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activitySponsorService.queryById(id));
	}
	
	@ApiOperation("获取活动评价列表")
	@RequestMapping(value = { "/getActivityReviewList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Map<?, ?> getActivityReviewList(@RequestBody Map<String, Object> params, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return result(1, null, activityReviewService.findList(params));
	}
	
	@ApiOperation("根据ID获取活动评价信息")
	@RequestMapping(value = { "/getActivityReviewById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result getActivityReviewById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityReviewService.queryById(id));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("新增活动报名")
	@RequestMapping(value = { "/activitySignUp" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result activitySignUp(@Valid @RequestBody ActivitySignUp activitySignUp, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ObjectMapper om = new ObjectMapper();
		if (activitySignUpService.count(om.convertValue(activitySignUp, Map.class)) > 0) {
			LOGGER.info(String.format("报名失败，不能重复报名 :  activityId=[%d], phone=[%s]", activitySignUp.getActivityId(), activitySignUp.getPhone()));
			return new Result(0, "报名失败，不能重复报名", null);
		}
		
		activitySignUp.setStatus(0);
		activitySignUp.setSignUpTime(new Date());
		activitySignUp.setCreateTime(new Date());
		activitySignUp.setUpdateTime(new Date());
		activitySignUpService.add(activitySignUp);
		return new Result(1, "报名成功", null);
	}
	
	@ApiOperation("新增活动评价")
	@RequestMapping(value = { "/addActivityReview" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result addActivityReview(@RequestBody ActivityReview activityReview, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (activityReview == null) {
			return new Result(0, "数据为空，请确认数据是否齐全", null);
		} else if (activityReview.getContent() == null) {
			return new Result(0, "请输入评价内容", null);
		}
		activityReview.setCreateTime(new Date());
		activityReview.setUpdateTime(new Date());
		activityReviewService.add(activityReview);
		return new Result(1, "评价成功", null);
	}
	
	@ApiOperation("新增活动收藏")
	@RequestMapping(value = { "/activityMemberLike" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result activityMemberLike(@RequestBody ActivityMemberLike activityMemberLike, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (activityMemberLike == null) {
			return new Result(0, "数据为空，请用户信息是否为空", null);
		} else if (activityMemberLike.getPhone() == null) {
			return new Result(0, "请确认用户手机号码", null);
		}
		activityMemberLikeService.add(activityMemberLike);
		return new Result(1, "收藏成功", null);
	}
	
	@ApiOperation("取消活动收藏")
	@RequestMapping(value = { "/cancelActivityMemberLike" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Result cancelActivityMemberLike(@RequestBody ActivityMemberLike activityMemberLike,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (activityMemberLike == null) {
			return new Result(0, "数据为空，请用户信息是否为空", null);
		} else if (activityMemberLike.getPhone() == null) {
			return new Result(0, "请确认用户手机号码", null);
		}
		activityMemberLikeService.deleteByPhone(activityMemberLike);
		return new Result(1, "取消收藏成功", null);
	}
}
