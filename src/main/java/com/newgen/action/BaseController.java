package com.newgen.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.newgen.bean.MemberPoints;
import com.newgen.bean.MemberPointsLog;
import com.newgen.service.MemberPointsLogService;
import com.newgen.service.MemberPointsService;
import com.newgen.util.Constant.MemberPointsType;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@Controller
public class BaseController {
	
	@Autowired
	protected MemberPointsService<MemberPoints> memberPointsService;
	
	@Autowired
	private MemberPointsLogService<MemberPointsLog> memberPointsLogService;

	/**
	 * 添加积分处理
	 * @param memberId 会员表主键
	 * @param type 类型
	 * @return
	 * @throws Exception
	 */
	protected Boolean increaseMemberPoints(Integer memberId, MemberPointsType type) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isToday", 1);
		params.put("memberId", memberId);
		params.put("type", type.name());
		List<MemberPointsLog> list = memberPointsLogService.findList(params);
		if (list.size() < type.getMaxTimes()) {
			MemberPoints memberPoints = memberPointsService.findByMemberId(memberId);
			memberPoints.setPoints(memberPoints.getPoints() + type.getPoints());
			Boolean updateMemberPoints = memberPointsService.update(memberPoints);
			if (updateMemberPoints) {
				memberPointsLogService.add(memberPointsLogService.newMemberPointsLog(memberId, type));
				return true;
			}
		}
		return false;
	}
}
