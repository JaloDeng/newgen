package com.newgen.backmanager.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:24
 */

public class ActivityUser implements UserDetails {

	private static final long serialVersionUID = 1623910388009084221L;

	private Integer id;

	private String name;
	
	private String phone;
	
	private String telephone;
	
	private String address;
	
	private boolean enabled;
	
	private String username;
	
	private String password;
	
	private String userface;
	
	private String remark;
	
	private List<ActivityRole> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserface() {
		return userface;
	}

	public void setUserface(String userface) {
		this.userface = userface;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ActivityRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ActivityRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "ActivityUser [id=" + id + ", name=" + name + ", phone=" + phone + ", telephone=" + telephone
				+ ", address=" + address + ", enabled=" + enabled + ", username=" + username + ", password=" + password
				+ ", userface=" + userface + ", remark=" + remark + ", roles=" + roles + "]";
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		this.roles.stream().forEach(role -> {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return grantedAuthorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
}
