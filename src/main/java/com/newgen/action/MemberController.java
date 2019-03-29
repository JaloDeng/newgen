package com.newgen.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.bean.MemberPoints;
import com.newgen.service.MemberPointsService;

@Controller
public class MemberController {

	@Autowired
	private MemberPointsService<MemberPoints> memberPointsService;
	
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
		return null;
	}
}
