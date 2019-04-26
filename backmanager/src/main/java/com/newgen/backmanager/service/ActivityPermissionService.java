package com.newgen.backmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.backmanager.bean.ActivityPermission;
import com.newgen.backmanager.mapper.ActivityPermissionMapper;
import com.newgen.commons.service.BaseService;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 10:50
 */

@Service
public class ActivityPermissionService extends BaseService<ActivityPermission> {
	
	@Autowired
	private ActivityPermissionMapper activityPermissionMapper;
	
	public List<ActivityPermission> queryByAdminId(Integer adminId) {
		return activityPermissionMapper.queryByAdminId(adminId);
	}
}
