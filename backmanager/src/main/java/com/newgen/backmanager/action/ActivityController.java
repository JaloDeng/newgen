package com.newgen.backmanager.action;

import java.util.List;
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

import com.newgen.commons.bean.Activity;
import com.newgen.commons.bean.ActivitySponsor;
import com.newgen.commons.model.Result;
import com.newgen.commons.service.ActivityReviewService;
import com.newgen.commons.service.ActivityService;
import com.newgen.commons.service.ActivitySignUpService;
import com.newgen.commons.service.ActivitySponsorService;
import com.newgen.commons.util.DataDictionary;
import com.newgen.commons.util.DataDictionary.ActivityStatusType;

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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);
	
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
	public @ResponseBody Result getActivityById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityService.queryById(id));
	}
	
	@ApiOperation("获取活动列表")
	@RequestMapping(value = { "/getActivityList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getActivityList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new Result(1, null, activityService.findByConditions(params), activityService.findCountByConditions(params));
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
	
	@ApiOperation("提交审核")
	@RequestMapping(value = { "/activityApplyCheck" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result activityApplyCheck(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			activityService.updateStatusById(id, ActivityStatusType.CHECKING);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(1, "提交失败 : " + e.getMessage(), null);
		}
		return new Result(1, "提交成功，请等待审核", null);
	}
	
	@ApiOperation("审核通过")
	@RequestMapping(value = { "/activityPassed" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result activityPassed(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			activityService.updateStatusById(id, ActivityStatusType.PASSED);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(1, "审核通过失败 : " + e.getMessage(), null);
		}
		return new Result(1, "审核通过成功", null);
	}
	
	@ApiOperation("审核退回")
	@RequestMapping(value = { "/activityNoPassed" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result activityNoPassed(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			activityService.updateStatusById(id, ActivityStatusType.NEW);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(1, "审核退回失败 : " + e.getMessage(), null);
		}
		return new Result(1, "审核退回成功", null);
	}
	
	@ApiOperation("活动发布")
	@RequestMapping(value = { "/activityRelease" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result activityRelease(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			activityService.updateStatusById(id, ActivityStatusType.SIGNUP);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(1, "活动发布失败 : " + e.getMessage(), null);
		}
		return new Result(1, "活动发布成功", null);
	}
	
	@ApiOperation("关闭报名")
	@RequestMapping(value = { "/activityClosed" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result activityClosed(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			activityService.updateStatusById(id, ActivityStatusType.CLOSED);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(1, "关闭报名失败 : " + e.getMessage(), null);
		}
		return new Result(1, "关闭报名成功", null);
	}
	
	@ApiOperation("测试数据")
	@RequestMapping(value = { "/test" }, produces = { "application/json;charset=UTF-8" }, method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody List<Map<String, Object>> test(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return DataDictionary.getActivityStatusTypeValues();
	}
}
