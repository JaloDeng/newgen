package com.newgen.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.bean.ActivitySignUp;
import com.newgen.app.mapper.ActivitySignUpMapper;
import com.newgen.app.mapper.BaseMapper;

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
