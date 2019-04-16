package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.ActivityMemberLike;
import com.newgen.mapper.ActivityMemberLikeMapper;
import com.newgen.mapper.BaseMapper;

@Service
public class ActivityMemberLikeService extends BaseService<ActivityMemberLike> {

	@Autowired
	private ActivityMemberLikeMapper activityMemberLikeMapper;
	
	@Override
	public BaseMapper<ActivityMemberLike> getMapper() {
		return this.activityMemberLikeMapper;
	}
	
	public void deleteByPhone(ActivityMemberLike ActivityMemberLike) {
		activityMemberLikeMapper.deleteByPhone(ActivityMemberLike);
	}
}
