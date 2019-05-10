package com.newgen.backmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newgen.backmanager.bean.ActivityRole;
import com.newgen.backmanager.bean.ActivityUser;
import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:27
 */

public interface ActivityUserMapper extends BaseMapper<ActivityUser> {

	public ActivityUser loadUserByUsername(@Param("username") String username);
	
	public List<ActivityRole> getRolesByUserId(@Param("userId") Integer userId);
	
	public List<ActivityUser> getUserByKeywords(@Param("keywords") String keywords);
	
	public List<ActivityUser> findListByCurrentId(@Param("currentId") Integer currentId);
	
	public ActivityUser queryById(@Param("id") Integer id);
	
	public Integer addRolesForUser(@Param("activityUserId") Integer activityUserId, @Param("activityRoleIds") Integer[] activityRoleIds);
	
	public Integer deleteUserRoleByUserId(@Param("userId") Integer userId);
}
