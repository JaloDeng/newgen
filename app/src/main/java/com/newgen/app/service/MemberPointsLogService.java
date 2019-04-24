package com.newgen.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newgen.app.bean.MemberPointsLog;
import com.newgen.app.mapper.BaseMapper;
import com.newgen.app.mapper.MemberPointsLogMapper;
import com.newgen.app.util.Constant.MemberPointsType;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Service
public class MemberPointsLogService<T> extends BaseService<T> {

	@Autowired
	private MemberPointsLogMapper<T> memberPointsLogMapper;
	
	@Override
	public BaseMapper<T> getMapper() {
		return this.memberPointsLogMapper;
	}
	
	public MemberPointsLog newMemberPointsLog(Integer memberId, MemberPointsType memberPointsType) {
		MemberPointsLog memberPointsLog = new MemberPointsLog();
		memberPointsLog.setMemberId(memberId);
		memberPointsLog.setPoints(memberPointsType.getPoints());
		memberPointsLog.setType(memberPointsType.name());
		memberPointsLog.setDataId(0);
		memberPointsLog.setDescription(memberPointsType.getDescription());
		memberPointsLog.setCreateTime(new Date());
		memberPointsLog.setUpdateTime(new Date());
		
		return memberPointsLog;
	}
}
