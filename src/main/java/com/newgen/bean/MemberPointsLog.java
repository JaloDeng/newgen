package com.newgen.bean;

import java.util.Date;

public class MemberPointsLog {

	private Long id;
	
	private Integer memberId;
	
	private Integer points;
	
	private String type;
	
	private Integer dataId;
	
	private String description;
	
	private Date createTime;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "MemberPointsLog [id=" + id + ", memberId=" + memberId + ", points=" + points + ", type=" + type
				+ ", dataId=" + dataId + ", description=" + description + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
}
