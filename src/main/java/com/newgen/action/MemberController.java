package com.newgen.action;

import java.util.Date;
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

@Controller
public class MemberController {

	@Autowired
	private MemberPointsService<MemberPoints> memberPointsService;
	
	@Autowired
	private MemberPointsLogService<MemberPointsLog> memberPointsLogService;
	
	@GetMapping(value = {"/getMemberPointsByMemberId"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<?, ?> getMemberPointsByMemberId(@RequestParam(required = true) Integer memberId) {
		MemberPoints memberPoints = memberPointsService.findByMemberId(memberId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", 1);
		map.put("data", memberPoints);
		return map;
	}
	
	@PostMapping(value = {"/memberSignIn"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<?, ?> memberSignIn(@RequestParam(required = true) Integer memberId) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		params.put("isToday", 1);
		params.put("memberId", memberId);
		params.put("type", "signIn");
		List<MemberPointsLog> list = memberPointsLogService.findList(params);
		if (list.size() == 0) {
			MemberPointsLog memberPointsLog = new MemberPointsLog();
			memberPointsLog.setMemberId(memberId);
			memberPointsLog.setPoints(2);
			memberPointsLog.setType("signIn");
			memberPointsLog.setDataId(0);
			memberPointsLog.setDescription("签到");
			memberPointsLog.setCreateTime(new Date());
			memberPointsLog.setUpdateTime(new Date());
			memberPointsLogService.add(memberPointsLog);
			
			result.put("ret", 1);
			result.put("msg", "签到成功");
			result.put("data", memberPointsLog);
			return result;
		}
		
		result.put("ret", 0);
		result.put("msg", "已签到");
		result.put("data", list.get(0));
		return result;
	}
}
