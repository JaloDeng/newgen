package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.mapper.BaseMapper;
import com.newgen.mapper.MemberPointsMapper;

@Service("memberPointsService")
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
