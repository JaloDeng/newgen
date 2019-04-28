package com.newgen.commons.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class ActivityPaymentLog {

	private String id;
	
	private String activitySignUpId;
	
	private BigDecimal amount;
	
	private String serialNumber;
	
	private String remark;
	
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
		return "ActivityPaymentLog [id=" + id + ", activitySignUpId=" + activitySignUpId + ", amount=" + amount
				+ ", serialNumber=" + serialNumber + ", remark=" + remark + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
