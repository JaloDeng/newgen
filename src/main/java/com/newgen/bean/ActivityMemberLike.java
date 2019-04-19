package com.newgen.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class ActivityMemberLike {

	private Long id;
	
	@NotNull(message = "活动ID不能为空")
	private Long activityId;
	
	@Pattern(regexp = "^\\d{11,11}$", message = "请输入正确的手机号码")
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ActivityMemberLike [id=" + id + ", activityId=" + activityId + ", phone=" + phone + "]";
	}

}
