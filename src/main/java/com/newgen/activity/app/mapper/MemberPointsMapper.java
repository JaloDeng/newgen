package com.newgen.activity.app.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface MemberPointsMapper<T> extends BaseMapper<T> {
	T findByMemberId(@Param("memberId") Integer memberId);
}
