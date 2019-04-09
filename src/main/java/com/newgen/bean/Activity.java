package com.newgen.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Activity {

	private Long id;
	
	private Integer status;
	
	private String title;
	
	private String summary;
	
	private Integer sponsorId;
	
	private String homePath;
	
	private String serialNumber;
	
	private String editor;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fromTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date toTime;
	
	private String address;
	
	private String detail;
	
	private String expenseExplanation;
	
	private String refundExplanation;
	
	private String notice;
	
	private String remark;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date releaseTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	
	private List<ActivityPackage> activityExpenses;
	
	private List<ActivitySignUp> activitySignUps;
	
	private List<ActivityPaymentLog> activityPaymentLogs;
	
	private List<ActivityRefundLog> activityRefundLogs;
	
	private List<ActivityMemberLike> activityMemberLikes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getHomePath() {
		return homePath;
	}

	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getExpenseExplanation() {
		return expenseExplanation;
	}

	public void setExpenseExplanation(String expenseExplanation) {
		this.expenseExplanation = expenseExplanation;
	}

	public String getRefundExplanation() {
		return refundExplanation;
	}

	public void setRefundExplanation(String refundExplanation) {
		this.refundExplanation = refundExplanation;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
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

	public List<ActivityPackage> getActivityExpenses() {
		return activityExpenses;
	}

	public void setActivityExpenses(List<ActivityPackage> activityExpenses) {
		this.activityExpenses = activityExpenses;
	}

	public List<ActivitySignUp> getActivitySignUps() {
		return activitySignUps;
	}

	public void setActivitySignUps(List<ActivitySignUp> activitySignUps) {
		this.activitySignUps = activitySignUps;
	}

	public List<ActivityPaymentLog> getActivityPaymentLogs() {
		return activityPaymentLogs;
	}

	public void setActivityPaymentLogs(List<ActivityPaymentLog> activityPaymentLogs) {
		this.activityPaymentLogs = activityPaymentLogs;
	}

	public List<ActivityRefundLog> getActivityRefundLogs() {
		return activityRefundLogs;
	}

	public void setActivityRefundLogs(List<ActivityRefundLog> activityRefundLogs) {
		this.activityRefundLogs = activityRefundLogs;
	}

	public List<ActivityMemberLike> getActivityMemberLikes() {
		return activityMemberLikes;
	}

	public void setActivityMemberLikes(List<ActivityMemberLike> activityMemberLikes) {
		this.activityMemberLikes = activityMemberLikes;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", status=" + status + ", title=" + title + ", summary=" + summary
				+ ", sponsorId=" + sponsorId + ", homePath=" + homePath + ", serialNumber=" + serialNumber + ", editor="
				+ editor + ", fromTime=" + fromTime + ", toTime=" + toTime + ", address=" + address + ", detail="
				+ detail + ", expenseExplanation=" + expenseExplanation + ", refundExplanation=" + refundExplanation
				+ ", notice=" + notice + ", remark=" + remark + ", releaseTime=" + releaseTime + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", activityExpenses=" + activityExpenses
				+ ", activitySignUps=" + activitySignUps + ", activityPaymentLogs=" + activityPaymentLogs
				+ ", activityRefundLogs=" + activityRefundLogs + ", activityMemberLikes=" + activityMemberLikes + "]";
	}

}
