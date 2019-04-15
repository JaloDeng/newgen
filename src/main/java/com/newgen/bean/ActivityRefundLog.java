package com.newgen.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityRefundLog {

	private Long id;
	
	private Long activitySignUpId;
	
	private BigDecimal amount;
	
	private String serialNumber;
	
	private String remark;
	
	private Date createTime;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivitySignUpId() {
		return activitySignUpId;
	}

	public void setActivitySignUpId(Long activitySignUpId) {
		this.activitySignUpId = activitySignUpId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "ActivityRefundLog [id=" + id + ", activitySignUpId=" + activitySignUpId + ", amount=" + amount
				+ ", serialNumber=" + serialNumber + ", remark=" + remark + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
