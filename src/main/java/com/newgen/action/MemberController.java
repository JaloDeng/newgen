package com.newgen.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private MemberPointsLogService<MemberPointsLog> memberPointsLogService;
	
	@GetMapping(value = {"/getMemberPointsByMemberId"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<?, ?> getMemberPointsByMemberId(@RequestParam(required = true) Integer memberId) {
		MemberPoints memberPoints = memberPointsService.findByMemberId(memberId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", 1);
		map.put("data", memberPoints);
		return map;
	}
	
	@GetMapping(value = {"/memberSignIn"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Map<?, ?> memberSignIn(@RequestParam(required = true) Integer memberId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isToday", 1);
		params.put("memberId", memberId);
		try {
			List<MemberPointsLog> resultList = memberPointsLogService.findList(params);
			if (resultList.isEmpty()) {
				//TODO 写入MemberPointsLog
				MemberPointsLog memberPointsLog = new MemberPointsLog();
				memberPointsLog.setMemberId(memberId);
				memberPointsLog.setPoints(2);
				memberPointsLog.setDataId(0);
				memberPointsLog.setDescription("签到");
				memberPointsLog.setType("signIn");
				memberPointsLogService.add(memberPointsLog);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
