package com.newgen.backmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newgen.backmanager.bean.ActivityMenu;
import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:27
 */

public interface ActivityMenuMapper extends BaseMapper<ActivityMenu> {

	public List<ActivityMenu> queryByUserId(@Param("userId") Integer userId);
	
	public List<ActivityMenu> menuTree();
	
	public List<Integer> getMenuIdByRoleId(@Param("roleId") Integer roleId);
}
