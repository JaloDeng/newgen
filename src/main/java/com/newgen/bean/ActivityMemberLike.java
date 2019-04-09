package com.newgen.bean;

public class ActivityMemberLike {

	private Long id;
	
	private Long activityId;
	
	private Integer memberId;

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

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "ActivityMemberLike [id=" + id + ", activityId=" + activityId + ", memberId=" + memberId + "]";
	}
	
}
