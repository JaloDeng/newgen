package com.newgen.bean;

public class ActivityMemberLike {

	private Long id;
	
	private Long activityId;
	
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
