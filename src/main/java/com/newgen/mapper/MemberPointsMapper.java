package com.newgen.mapper;

import org.apache.ibatis.annotations.Param;

public interface MemberPointsMapper<T> extends BaseMapper<T> {
	T findByMemberId(@Param("memberId") Integer memberId);
}
