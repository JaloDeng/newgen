package com.newgen.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newgen.result.Result;
import com.newgen.util.Constant.MemberPointsType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api(value = "MemberController", tags = {"会员模块"})
public class MemberController extends BaseController {

	@ApiOperation("根据会员id获取会员积分")
	@GetMapping(value = {"/getMemberPointsByMemberId"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Result getMemberPointsByMemberId(@RequestParam(required = true) @ApiParam(value = "会员id", required = true, type = "Integer") Integer memberId) {
		return new Result(1, null, memberPointsService.findByMemberId(memberId));
	}
	
	@ApiOperation("会员签到")
	@ApiImplicitParam(name = "memberId", value = "会员id")
	@PostMapping(value = {"/memberSignIn"}, produces = {"application/json;charset=UTF-8"})
	public @ResponseBody Result memberSignIn(@RequestParam(required = true) Integer memberId) throws Exception {
		if (increaseMemberPoints(memberId, MemberPointsType.SIGNIN)) {
			return new Result(1, "签到成功", null);
		}
		return new Result(0, "已签到", null);
	}
	
}
