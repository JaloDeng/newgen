package com.newgen.bean;

import java.util.Date;
import java.util.List;

public class ActivitySponsor {

	private Long id;
	
	private String serialNumber;
	
	private String name;
	
	private String contact;
	
	private String phone;
	
	private String address;
	
	private String logoPath;
	
	private Integer score;
	
	private String declaration;
	
	private String summary;
	
	private Date createTime;
	
	private Date updateTime;
	
	private List<Activity> activities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		return "ActivitySponsor [id=" + id + ", serialNumber=" + serialNumber + ", name=" + name + ", contact="
				+ contact + ", phone=" + phone + ", address=" + address + ", logoPath=" + logoPath + ", score=" + score
				+ ", declaration=" + declaration + ", summary=" + summary + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", activities=" + activities + "]";
	}

}
