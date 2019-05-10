package com.newgen.backmanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newgen.backmanager.bean.ActivityUser;
import com.newgen.backmanager.mapper.ActivityUserMapper;
import com.newgen.commons.service.BaseService;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-05-08 17:09
 */

@Service
@Transactional
public class ActivityUserService extends BaseService<ActivityUser> implements UserDetailsService {

	@Autowired
	private ActivityUserMapper activityUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ActivityUser activityUser = activityUserMapper.loadUserByUsername(username);
		if (activityUser == null) {
			throw new UsernameNotFoundException("用户名错误");
		}
		return activityUser;
	}

	@Override
	public Integer add(ActivityUser activityUser) throws Exception {
		if (activityUserMapper.loadUserByUsername(activityUser.getUsername()) != null) {
			return -1;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		activityUser.setPassword(encoder.encode(activityUser.getPassword()));
		return activityUserMapper.add(activityUser);
	}
	
	public List<ActivityUser> getUserByKeywords(String keywords) {
		return activityUserMapper.getUserByKeywords(keywords);
	}
	
	public List<ActivityUser> findListByCurrentId(Integer currentId) {
		ActivityUser activityUser = (ActivityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentId", activityUser.getId());
		return activityUserMapper.findList(params);
	}
	
	public ActivityUser queryById(Integer id) {
		return activityUserMapper.queryById(id);
	}
	
	public Integer updateActivityUserRoles(Integer activityUserId, Integer[] activityRoleIds) {
		activityUserMapper.deleteUserRoleByUserId(activityUserId);
		return activityUserMapper.addRolesForUser(activityUserId, activityRoleIds);
	}
}
