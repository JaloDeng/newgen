package com.newgen.backmanager.bean;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:17
 */

public class Admin {

	private Integer id;
	
	private Integer deptid;
	
	private String usercode;
	
	private String username;
	
	private String password;
	
	private String position;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private Integer roleid;
	
	private Integer islock;
	
	private Integer flag;
	
	private String openid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getIslock() {
		return islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", deptid=" + deptid + ", usercode=" + usercode + ", username=" + username
				+ ", password=" + password + ", position=" + position + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", roleid=" + roleid + ", islock=" + islock + ", flag=" + flag + ", openid="
				+ openid + "]";
	}
	
}
