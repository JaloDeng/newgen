package com.newgen.activity.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.activity.app.bean.ActivitySignUp;
import com.newgen.activity.app.mapper.ActivitySignUpMapper;
import com.newgen.activity.app.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivitySignUpService extends BaseService<ActivitySignUp> {

	@Autowired
	private ActivitySignUpMapper activitySignUpMapper;

	@Override
	public BaseMapper<ActivitySignUp> getMapper() {
		return this.activitySignUpMapper;
	}
	
}
