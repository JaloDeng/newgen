package com.newgen.app.action;

import java.util.Date;
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
import com.newgen.app.bean.ActivityMemberLike;
import com.newgen.app.bean.ActivityReview;
import com.newgen.app.bean.ActivitySignUp;
import com.newgen.commons.model.Result;
import com.newgen.app.service.ActivityMemberLikeService;
import com.newgen.app.service.ActivityReviewService;
import com.newgen.app.service.ActivityService;
import com.newgen.app.service.ActivitySignUpService;
import com.newgen.app.service.ActivitySponsorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

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
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivityById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
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
	public @ResponseBody Result getActivitySignUpById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
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
	public @ResponseBody Result getActivitySponsorById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
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
	public @ResponseBody Result getActivityReviewById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityReviewService.queryById(id));
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("新增活动报名")
	@RequestMapping(value = { "/activitySignUp" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
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
	
	@SuppressWarnings("unchecked")
	@ApiOperation("新增活动评价")
	@RequestMapping(value = { "/addActivityReview" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result addActivityReview(@Valid @RequestBody ActivityReview activityReview,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ObjectMapper om = new ObjectMapper();
		if (activityReviewService.count(om.convertValue(activityReview, Map.class)) > 0) {
			LOGGER.info(String.format("评价失败，不能重复评价 :  activityId=[%d], getActivitySignUpId=[%s]",
					activityReview.getActivityId(), activityReview.getActivitySignUpId()));
			return new Result(0, "评价失败，不能重复评价", null);
		}

		activityReview.setCreateTime(new Date());
		activityReview.setUpdateTime(new Date());
		activityReviewService.add(activityReview);
		return new Result(1, "评价成功", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("新增活动收藏")
	@RequestMapping(value = { "/activityMemberLike" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result activityMemberLike(@Valid @RequestBody ActivityMemberLike activityMemberLike, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ObjectMapper om = new ObjectMapper();
		if (activityMemberLikeService.count(om.convertValue(activityMemberLike, Map.class)) > 0 ) {
			LOGGER.info(String.format("收藏失败，不能重复收藏 :  activityId=[%d], phone=[%s]", activityMemberLike.getActivityId(), activityMemberLike.getPhone()));
			return new Result(0, "收藏失败，不能重复收藏", null);
		}
		
		activityMemberLikeService.add(activityMemberLike);
		return new Result(1, "收藏成功", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("取消活动收藏")
	@RequestMapping(value = { "/cancelActivityMemberLike" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result cancelActivityMemberLike(@Valid @RequestBody ActivityMemberLike activityMemberLike,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ObjectMapper om = new ObjectMapper();
		if (activityMemberLikeService.count(om.convertValue(activityMemberLike, Map.class)) > 0 ) {
			activityMemberLikeService.deleteByPhone(activityMemberLike);
		}
		return new Result(1, "取消收藏成功", null);
	}
}
