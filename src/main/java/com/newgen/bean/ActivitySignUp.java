package com.newgen.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ActivitySignUp {

	private Long id;
	
	private Long activityId;
	
	private Integer memberId;
	
	private Long activityPackageId;
	
	private String serialNumber;
	
	private Integer status;
	
	private BigDecimal amount;
	
	private String channel;
	
	private String name;
	
	private String phone;
	
	private String IDCard;
	
	private Date signUpTime;
	
	private Date cancelSignUpTime;
	
	private String remark;
	
	private Date createTime;
	
	private Date updateTime;
	
	//表t_activity字段，非本表字段
	private String activityTitle;
	
	//表t_activity_package字段，非本表字段
	private String activityPackageTitle;
	private BigDecimal activityPackagePrice;
	
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

	public Long getActivityPackageId() {
		return activityPackageId;
	}

	public void setActivityPackageId(Long activityPackageId) {
		this.activityPackageId = activityPackageId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String IDCard) {
		this.IDCard = IDCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityPackageTitle() {
		return activityPackageTitle;
	}

	public void setActivityPackageTitle(String activityPackageTitle) {
		this.activityPackageTitle = activityPackageTitle;
	}

	public BigDecimal getActivityPackagePrice() {
		return activityPackagePrice;
	}

	public void setActivityPackagePrice(BigDecimal activityPackagePrice) {
		this.activityPackagePrice = activityPackagePrice;
	}

	@Override
	public String toString() {
		return "ActivitySignUp [id=" + id + ", activityId=" + activityId + ", memberId=" + memberId
				+ ", activityPackageId=" + activityPackageId + ", serialNumber=" + serialNumber + ", status=" + status
				+ ", amount=" + amount + ", channel=" + channel + ", name=" + name + ", phone=" + phone + ", IDCard="
				+ IDCard + ", signUpTime=" + signUpTime + ", cancelSignUpTime=" + cancelSignUpTime + ", remark="
				+ remark + ", createTime=" + createTime + ", updateTime=" + updateTime + ", activityTitle="
				+ activityTitle + ", activityPackageTitle=" + activityPackageTitle + ", activityPackagePrice="
				+ activityPackagePrice + "]";
	}

}
