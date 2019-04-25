package com.newgen.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.bean.MemberPoints;
import com.newgen.app.mapper.MemberPointsMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class MemberPointsService extends BaseService<MemberPoints> {

	@Autowired
	private MemberPointsMapper<MemberPoints> memberPointsMapper;

	public MemberPoints findByMemberId(Integer memberId) {
		return memberPointsMapper.findByMemberId(memberId);
	}
}
