package com.newgen.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.bean.MemberPoints;
import com.newgen.bean.MemberPointsLog;
import com.newgen.service.MemberPointsLogService;
import com.newgen.service.MemberPointsService;
import com.newgen.util.Constant.MemberPointsType;

@Controller
public class MemberController {

	@Autowired
	private MemberPointsService<MemberPoints> memberPointsService;
	
	@Autowired
	private MemberPointsLogService<MemberPointsLog> memberPointsLogService;
	
	@SuppressWarnings("rawtypes")
	private Map result = new HashMap();
	
	@GetMapping(value = {"/getMemberPointsByMemberId"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<?, ?> getMemberPointsByMemberId(@RequestParam(required = true) Integer memberId) {
		return result(1, null, memberPointsService.findByMemberId(memberId));
	}
	
	@PostMapping(value = {"/memberSignIn"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<?, ?> memberSignIn(@RequestParam(required = true) Integer memberId) throws Exception {
		if (increaseMemberPoints(memberId, MemberPointsType.SIGNIN)) {
			return result(1, "签到成功", null);
		}
		return result(0, "已签到", null);
	}
	
	private Boolean increaseMemberPoints(Integer memberId, MemberPointsType type) throws Exception {
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
	
	@SuppressWarnings("unchecked")
	private Map<?, ?> result(Integer ret, String msg, Object data) {
		this.result.put("ret", ret);
		this.result.put("msg", msg);
		this.result.put("data", data);
		return result;
	}
}
