package com.newgen.app.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class ActivityReview {

	private Long id;
	
	@NotNull(message = "活动报名ID不能为空")
	private Integer activitySignUpId;
	
	@NotNull(message = "活动ID不能为空")
	private Integer activityId;
	
	@NotNull(message = "评价内容不能为空")
	private String content;
	
	private String picture;
	
	private Date createTime;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getActivitySignUpId() {
		return activitySignUpId;
	}

	public void setActivitySignUpId(Integer activitySignUpId) {
		this.activitySignUpId = activitySignUpId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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
		return "ActivityReview [id=" + id + ", activitySignUpId=" + activitySignUpId + ", activityId=" + activityId
				+ ", content=" + content + ", picture=" + picture + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}
