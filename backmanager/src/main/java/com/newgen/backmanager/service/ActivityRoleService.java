package com.newgen.backmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newgen.backmanager.bean.ActivityRole;
import com.newgen.backmanager.mapper.ActivityRoleMapper;
import com.newgen.commons.service.BaseService;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 10:50
 */

@Service
@Transactional
public class ActivityRoleService extends BaseService<ActivityRole> {
	
	@Autowired
	private ActivityRoleMapper activityRoleMapper;
	
	@Override
	public Integer add(ActivityRole activityRole) throws Exception {
		if (!activityRole.getName().startsWith("ROLE_")) {
			activityRole.setName("ROLE_" + activityRole.getName());
		}
		return activityRoleMapper.add(activityRole);
	}
	
	public Integer updateMenuByRoleId(Integer activityRoleId, Integer[] menuIds) {
		activityRoleMapper.deleteMenuByRoleId(activityRoleId);
		if (menuIds.length == 0) {
			return 0;
		}
		return activityRoleMapper.addMenuByRoleId(activityRoleId, menuIds);
	}
	
}
