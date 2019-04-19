package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.bean.ActivityMemberLike;
import com.newgen.mapper.ActivityMemberLikeMapper;
import com.newgen.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

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
