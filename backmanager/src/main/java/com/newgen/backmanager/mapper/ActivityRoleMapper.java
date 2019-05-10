package com.newgen.backmanager.mapper;

import org.apache.ibatis.annotations.Param;

import com.newgen.backmanager.bean.ActivityRole;
import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:27
 */

public interface ActivityRoleMapper extends BaseMapper<ActivityRole> {
	
	public Integer addMenuByRoleId(@Param("activityRoleId") Integer activityRoleId, @Param("menuIds") Integer[] menuIds);
	
	public Integer deleteMenuByRoleId(@Param("roleId") Integer roleId);
	
}
