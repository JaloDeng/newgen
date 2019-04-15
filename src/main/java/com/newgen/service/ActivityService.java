package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.Activity;
import com.newgen.mapper.ActivityMapper;
import com.newgen.mapper.BaseMapper;

@Service
public class ActivityService extends BaseService<Activity> {

	@Autowired
	private ActivityMapper activityMapper;
	
	@Override
	public BaseMapper<Activity> getMapper() {
		return this.activityMapper;
	}
	
}
