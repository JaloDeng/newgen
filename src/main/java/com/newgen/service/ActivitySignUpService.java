package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.ActivitySignUp;
import com.newgen.mapper.ActivitySignUpMapper;
import com.newgen.mapper.BaseMapper;

@Service
public class ActivitySignUpService extends BaseService<ActivitySignUp> {

	@Autowired
	private ActivitySignUpMapper activitySignUpMapper;

	@Override
	public BaseMapper<ActivitySignUp> getMapper() {
		return this.activitySignUpMapper;
	}
	
	public void add() {
		
	}
}
