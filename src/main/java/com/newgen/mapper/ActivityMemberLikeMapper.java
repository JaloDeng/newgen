package com.newgen.mapper;

import com.newgen.bean.ActivityMemberLike;

public interface ActivityMemberLikeMapper extends BaseMapper<ActivityMemberLike> {
	
	public void deleteByPhone(ActivityMemberLike ActivityMemberLike);
}
