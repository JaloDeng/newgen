package com.newgen.backmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newgen.backmanager.bean.ActivityMenu;
import com.newgen.backmanager.mapper.ActivityMenuMapper;
import com.newgen.commons.service.BaseService;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 10:50
 */

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class ActivityMenuService extends BaseService<ActivityMenu> {
	
	@Autowired
	private ActivityMenuMapper activityMenuMapper;
	
	public List<ActivityMenu> menuTree() {
		return activityMenuMapper.menuTree();
	}
	
	public List<ActivityMenu> queryByUserId(Integer userId) {
		return activityMenuMapper.queryByUserId(userId);
	}
	
	public List<Integer> getMenuIdByRoleId(Integer roleId) {
		return activityMenuMapper.getMenuIdByRoleId(roleId);
	}
	
	public List<ActivityMenu> findAll() {
		return activityMenuMapper.findAll();
	}
}
