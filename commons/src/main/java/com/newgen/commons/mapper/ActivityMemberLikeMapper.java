package com.newgen.commons.mapper;

import com.newgen.commons.bean.ActivityMemberLike;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface ActivityMemberLikeMapper extends BaseMapper<ActivityMemberLike> {
	
	public void deleteByPhone(ActivityMemberLike ActivityMemberLike);
}
