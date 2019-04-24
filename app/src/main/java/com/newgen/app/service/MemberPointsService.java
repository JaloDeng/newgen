package com.newgen.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.mapper.BaseMapper;
import com.newgen.app.mapper.MemberPointsMapper;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class MemberPointsService<T> extends BaseService<T> {

	@Autowired
	private MemberPointsMapper<T> memberPointsMapper;

	@Override
	public BaseMapper<T> getMapper() {
		return this.memberPointsMapper;
	}
	
	public T findByMemberId(Integer memberId) {
		return this.memberPointsMapper.findByMemberId(memberId);
	}
}
