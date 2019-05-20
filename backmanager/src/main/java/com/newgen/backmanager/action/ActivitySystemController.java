package com.newgen.backmanager.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.backmanager.bean.ActivityRole;
import com.newgen.backmanager.bean.ActivityUser;
import com.newgen.backmanager.service.ActivityMenuService;
import com.newgen.backmanager.service.ActivityRoleService;
import com.newgen.backmanager.service.ActivityUserService;
import com.newgen.commons.model.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 11:02
 */

@Api(value = "ActivitySystemController", tags = {"角色菜单模块"})
@Controller
public class ActivitySystemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySystemController.class);

	@Autowired
	private ActivityMenuService activityMenuService;
	
	@Autowired
	private ActivityRoleService activityRoleService;
	
	@Autowired
	private ActivityUserService activityUserService;
	
	@ApiOperation("删除角色")
	@RequestMapping(value = { "/deleteRoleById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.DELETE, RequestMethod.POST })
	public @ResponseBody Result deleteRoleById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			activityRoleService.delete(id);
			return new Result(1, "删除成功", null);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "删除失败", null);
		}
	}
	
	@ApiOperation("添加角色")
	@RequestMapping(value = { "/addRole" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.POST })
	public @ResponseBody Result addRole(@RequestBody ActivityRole activityRole, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			activityRoleService.add(activityRole);
			return new Result(1, "添加成功", null);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "添加失败", null);
		}
	}
	
	@ApiOperation("获取菜单树结构")
	@RequestMapping(value = { "/getMenuTreeByRoleId" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getMenuTree(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			Map<String, Object> menuTree = new HashMap<String, Object>();
			menuTree.put("menus", activityMenuService.menuTree());
			menuTree.put("mids", activityMenuService.getMenuIdByRoleId(id));
			return new Result(1, "获取菜单成功", menuTree);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "获取菜单失败", null);
		}
	}
	
	@ApiOperation("根据roleId修改角色拥有的菜单")
	@RequestMapping(value = { "/updateMenuByRoleId" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.POST })
	public @ResponseBody Result updateMenuByRoleId(@RequestParam Integer roleId, @RequestParam Integer[] menuIds, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			if (activityRoleService.updateMenuByRoleId(roleId, menuIds) == menuIds.length) {
				return new Result(1, "修改菜单成功", null);
			} else { 
				return new Result(0, "修改菜单失败", null);
			}
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "修改菜单失败", null);
		}
	}
	
	@ApiOperation("获取角色列表")
	@RequestMapping(value = { "/getRoleList" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getRoleList(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			return new Result(1, "获取成功", activityRoleService.findList(params));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "获取失败", null);
		}
	}
	
	@ApiOperation("根据ID获取用户")
	@RequestMapping(value = { "/getUserById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getUserById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			return new Result(1, "获取成功", activityUserService.queryById(id));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "获取失败", null);
		}
	}
	
	@ApiOperation("根据keywords获取用户")
	@RequestMapping(value = { "/getUserByKeywords" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getUserByKeywords(@RequestParam String keywords, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			return new Result(1, "获取成功", activityUserService.getUserByKeywords(keywords));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "获取失败", null);
		}
	}
	
	@ApiOperation("删除用户")
	@RequestMapping(value = { "/deleteUserById" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.DELETE, RequestMethod.POST })
	public @ResponseBody Result deleteUserById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			activityUserService.delete(id);
			return new Result(1, "删除成功", null);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "删除失败", null);
		}
	}
	
	@ApiOperation("修改用户")
	@RequestMapping(value = { "/updateUser" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.POST })
	public @ResponseBody Result deleteUserById(@RequestBody ActivityUser activityUser, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			activityUserService.update(activityUser);
			return new Result(1, "修改成功", null);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "修改失败", null);
		}
	}
	
	@ApiOperation("修改用户关联角色")
	@RequestMapping(value = { "/updateUserRoles" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.POST })
	public @ResponseBody Result updateUserRoles(@RequestParam Integer userId, @RequestParam Integer[] roleIds, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			activityUserService.updateActivityUserRoles(userId, roleIds);
			return new Result(1, "删除成功", null);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "删除失败", null);
		}
	}
	
	@ApiOperation("添加用户")
	@RequestMapping(value = { "/addUser" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.POST })
	public @ResponseBody Result addRole(@RequestBody ActivityUser activityUser, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			activityUserService.add(activityUser);
			return new Result(1, "添加成功", null);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "添加失败", null);
		}
	}
	
	@ApiOperation("获取当前用户菜单列表")
	@RequestMapping(value = { "/getMenuByCurrentUserId" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getMenuByCurrentUserId(@AuthenticationPrincipal ActivityUser activityUser, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			return new Result(1, "获取成功", activityMenuService.queryByUserId(activityUser.getId()));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "获取失败", null);
		}
	}
	
	@ApiOperation("获取当前用户")
	@RequestMapping(value = { "/getCurrentUser" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result getCurrentUser(@AuthenticationPrincipal ActivityUser activityUser, HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		try {
			return new Result(1, "获取成功", activityUser);
		} catch (Exception e) {
			LOGGER.error(e.toString());
			return new Result(0, "获取失败", null);
		}
	}
	
	@ApiOperation("登陆页面")
	@RequestMapping(value = { "/login_p" }, produces = { "application/json;charset=UTF-8" }, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result loginP(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new Result(0, "尚未登陆，请登陆", null);
	}
}
