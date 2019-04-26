package com.newgen.backmanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newgen.backmanager.bean.ActivityPermission;
import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:27
 */

public interface ActivityPermissionMapper extends BaseMapper<ActivityPermission> {

	public List<ActivityPermission> queryByAdminId(@Param("adminId") Integer adminId);
}
