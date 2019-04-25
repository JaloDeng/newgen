package com.newgen.app.mapper;

import org.apache.ibatis.annotations.Param;

import com.newgen.app.bean.MemberPoints;
import com.newgen.commons.mapper.BaseMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public interface MemberPointsMapper extends BaseMapper<MemberPoints> {
	public MemberPoints findByMemberId(@Param("memberId") Integer memberId);
}
