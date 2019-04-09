package com.newgen.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActivitySignUp {

	private Long id;
	
	private Long activityId;
	
	private Integer memberId;
	
	private Long activityExpenseId;
	
	private String serialNumber;
	
	private Integer status;
	
	private BigDecimal amount;
	
	private String channel;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date signUpTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cancelSignUpTime;
	
	private String remark;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

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

	public Long getActivityExpenseId() {
		return activityExpenseId;
	}

	public void setActivityExpenseId(Long activityExpenseId) {
		this.activityExpenseId = activityExpenseId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Date getSignUpTime() {
		return signUpTime;
	}

	public void setSignUpTime(Date signUpTime) {
		this.signUpTime = signUpTime;
	}

	public Date getCancelSignUpTime() {
		return cancelSignUpTime;
	}

	public void setCancelSignUpTime(Date cancelSignUpTime) {
		this.cancelSignUpTime = cancelSignUpTime;
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
		return "ActivitySignUp [id=" + id + ", activityId=" + activityId + ", memberId=" + memberId
				+ ", activityExpenseId=" + activityExpenseId + ", serialNumber=" + serialNumber + ", status=" + status
				+ ", amount=" + amount + ", channel=" + channel + ", signUpTime=" + signUpTime + ", cancelSignUpTime="
				+ cancelSignUpTime + ", remark=" + remark + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}

}
