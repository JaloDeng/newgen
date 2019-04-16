package com.newgen.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.bean.ActivityMemberLike;
import com.newgen.bean.ActivitySignUp;
import com.newgen.service.ActivityMemberLikeService;
import com.newgen.service.ActivityService;
import com.newgen.service.ActivitySignUpService;
import com.newgen.service.ActivitySponsorService;

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
	
	@Autowired
	private ActivitySponsorService activitySponsorService;
	
	@Autowired
	private ActivityMemberLikeService activityMemberLikeService;
	
	@ApiOperation("根据ID获取活动详细信息")
	@GetMapping(value = { "/getActivityById" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> getActivityById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return result(1, null, activityService.queryById(id));
	}
	
	@ApiOperation("获取活动列表")
	@GetMapping(value = { "/getActivityList" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> getActivityList(@RequestParam(required = false) @ApiParam("页码") Integer page,
			@RequestParam(required = false) @ApiParam("行数") Integer row, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("row", row);
		return result(1, null, activityService.findList(params));
	}
	
	@ApiOperation("根据ID获取报名信息")
	@GetMapping(value = { "/getActivitySignUpById" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> getActivitySignUpById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return result(1, null, activitySignUpService.queryById(id));
	}
	
	@ApiOperation("获取活动主办方列表")
	@GetMapping(value = { "/getActivitySponsorList" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> getActivitySponsorList(@RequestParam(required = false) @ApiParam("页码") Integer page,
			@RequestParam(required = false) @ApiParam("行数") Integer row, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("row", row);
		return result(1, null, activitySponsorService.findList(params));
	}
	
	@ApiOperation("根据ID获取活动主办方信息")
	@GetMapping(value = { "/getActivitySponsorById" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> getActivitySponsorById(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return result(1, null, activitySponsorService.queryById(id));
	}
	
	@ApiOperation("新增活动报名")
	@PostMapping(value = { "/activitySignUp" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> activitySignUp(@RequestBody ActivitySignUp activitySignUp, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (activitySignUp == null) {
			return result(0, "数据为空，请确认报名信息是否齐全", null);
		} else if (activitySignUp.getPhone() == null) {
			return result(0, "请输入手机号码", null);
		}
		activitySignUp.setStatus(0);
		activitySignUp.setSignUpTime(new Date());
		activitySignUp.setCreateTime(new Date());
		activitySignUp.setUpdateTime(new Date());
		activitySignUpService.add(activitySignUp);
		return result(1, "报名成功", null);
	}
	
	@ApiOperation("新增活动收藏")
	@PostMapping(value = { "/activityMemberLike" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> activityMemberLike(@RequestBody ActivityMemberLike activityMemberLike, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (activityMemberLike == null) {
			return result(0, "数据为空，请用户信息是否为空", null);
		} else if (activityMemberLike.getPhone() == null) {
			return result(0, "请确认用户手机号码", null);
		}
		activityMemberLikeService.add(activityMemberLike);
		return result(1, "收藏成功", null);
	}
	
	@ApiOperation("取消活动收藏")
	@DeleteMapping(value = { "/cancelActivityMemberLike" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Map<?, ?> cancelActivityMemberLike(@RequestBody ActivityMemberLike activityMemberLike,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (activityMemberLike == null) {
			return result(0, "数据为空，请用户信息是否为空", null);
		} else if (activityMemberLike.getPhone() == null) {
			return result(0, "请确认用户手机号码", null);
		}
		activityMemberLikeService.deleteByPhone(activityMemberLike);
		return result(1, "取消收藏成功", null);
	}
}
