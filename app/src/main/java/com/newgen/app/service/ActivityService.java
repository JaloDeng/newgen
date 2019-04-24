package com.newgen.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.bean.Activity;
import com.newgen.app.mapper.ActivityMapper;
import com.newgen.app.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivityService extends BaseService<Activity> {

	@Autowired
	private ActivityMapper activityMapper;
	
	@Override
	public BaseMapper<Activity> getMapper() {
		return this.activityMapper;
	}
	
}
