package com.newgen.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivitySignUp {

	private Long id;
	
	@NotNull(message = "活动ID不能为空")
	private Long activityId;
	
	private Integer memberId;
	
	@NotNull(message = "活动套餐ID不能为空")
	private Long activityPackageId;
	
	private String serialNumber;
	
	private Integer status;
	
	private BigDecimal amount;
	
	private String channel;
	
	@NotBlank(message = "姓名不能为空")
	private String name;
	
	@Pattern(regexp = "^\\d{11,11}$", message = "请输入正确的手机号码")
	private String phone;
	
	@NotBlank(message = "身份证号码不能为空")
	private String IDCard;
	
	private Date signUpTime;
	
	private Date cancelSignUpTime;
	
	private String remark;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Activity activity;
	
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "ActivitySignUp [id=" + id + ", activityId=" + activityId + ", memberId=" + memberId
				+ ", activityPackageId=" + activityPackageId + ", serialNumber=" + serialNumber + ", status=" + status
				+ ", amount=" + amount + ", channel=" + channel + ", name=" + name + ", phone=" + phone + ", IDCard="
				+ IDCard + ", signUpTime=" + signUpTime + ", cancelSignUpTime=" + cancelSignUpTime + ", remark="
				+ remark + ", createTime=" + createTime + ", updateTime=" + updateTime + ", activity=" + activity + "]";
	}

}
