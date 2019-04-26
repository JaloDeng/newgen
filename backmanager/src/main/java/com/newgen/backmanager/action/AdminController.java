package com.newgen.backmanager.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.backmanager.service.ActivityPermissionService;
import com.newgen.backmanager.service.ActivityRoleService;
import com.newgen.commons.model.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 11:02
 */

@Api(value = "AdminController", tags = {"后台登陆模块"})
@Controller
public class AdminController {

	@Autowired
	private ActivityPermissionService activityPermissionService;
	
	@Autowired
	private ActivityRoleService activityRoleService;
	
	@ApiOperation("获取权限列表")
	@RequestMapping(value = { "/getPermissionList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getPermissionList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(1, "", activityPermissionService.findList(params));
	}
	
	@ApiOperation("根据ID获取权限")
	@RequestMapping(value = { "/getPermissionById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getPermissionById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(1, "", activityPermissionService.queryById(id));
	}
	
	@ApiOperation("根据adminId获取权限")
	@RequestMapping(value = { "/getPermissionByAdminId" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getPermissionByAdminId(@RequestParam Integer adminId, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(1, "", activityPermissionService.queryByAdminId(adminId));
	}
	
	@ApiOperation("获取角色列表")
	@RequestMapping(value = { "/getRoleList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getRoleList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(1, "", activityRoleService.findList(params));
	}
	
	@ApiOperation("根据ID获取角色")
	@RequestMapping(value = { "/getRoleById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getRoleById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(1, "", activityRoleService.queryById(id));
	}
}
