package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.ActivityReview;
import com.newgen.mapper.ActivityReviewMapper;
import com.newgen.mapper.BaseMapper;

@Service
public class ActivityReviewService extends BaseService<ActivityReview> {

	@Autowired
	private ActivityReviewMapper activityReviewMapper;
	
	@Override
	public BaseMapper<ActivityReview> getMapper() {
		return this.activityReviewMapper;
	}
	
}
