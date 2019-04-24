package com.newgen.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.bean.ActivityReview;
import com.newgen.app.mapper.ActivityReviewMapper;
import com.newgen.app.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class ActivityReviewService extends BaseService<ActivityReview> {

	@Autowired
	private ActivityReviewMapper activityReviewMapper;
	
	@Override
	public BaseMapper<ActivityReview> getMapper() {
		return this.activityReviewMapper;
	}
	
}
