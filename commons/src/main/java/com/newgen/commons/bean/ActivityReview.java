package com.newgen.commons.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class ActivityReview {

	private String id;
	
	@NotNull(message = "活动报名ID不能为空")
	private String activitySignUpId;
	
	@NotNull(message = "活动ID不能为空")
	private String activityId;
	
	@NotNull(message = "评价内容不能为空")
	private String content;
	
	private String picture;
	
	private Date createTime;
	
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivitySignUpId() {
		return activitySignUpId;
	}

	public void setActivitySignUpId(String activitySignUpId) {
		this.activitySignUpId = activitySignUpId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
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
