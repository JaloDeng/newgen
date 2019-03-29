package com.newgen.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberPoints {

	private Integer memberId;
	private Integer points;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	
	public MemberPoints(Integer memberId, Integer points, Date createTime, Date updateTime) {
		this.memberId = memberId;
		this.points = points;
		this.createTime = new Date();
		this.updateTime = updateTime;
	}

	public Integer getMemberId() {
		return memberId;
	}
	
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "MemberPoints [memberId=" + memberId + ", points=" + points + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
}
