package com.newgen.app.bean;

import java.util.Date;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class MemberPoints {

	private Integer memberId;
	private Integer points;
	
	private Date createTime;
	
	private Date updateTime;
	
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
