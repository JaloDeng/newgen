package com.newgen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.mapper.BaseMapper;
import com.newgen.mapper.MemberPointsLogMapper;

@Service
public class MemberPointsLogService<T> extends BaseService<T> {

	@Autowired
	private MemberPointsLogMapper<T> memberPointsLogMapper;
	
	@Override
	public BaseMapper<T> getMapper() {
		return this.memberPointsLogMapper;
	}
	
}
