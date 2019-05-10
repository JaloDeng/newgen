package com.newgen.backmanager.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:12
 */

public class ActivityMenu implements Serializable {

	private static final long serialVersionUID = -6880655476951657172L;

	private Integer id;
	
	private String url;
	
	private String path;
	
	private Object component;
	
	private String name;
	
	private String iconCls;
	
	private Integer parentId;

	private List<ActivityRole> roles;
	
	private List<ActivityMenu> children;
	
	private ActivityMenuMeta meta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public Object getComponent() {
		return component;
	}

	public void setComponent(Object component) {
		this.component = component;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@JsonIgnore
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@JsonIgnore
	public List<ActivityRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ActivityRole> roles) {
		this.roles = roles;
	}

	public List<ActivityMenu> getChildren() {
		return children;
	}

	public void setChildren(List<ActivityMenu> children) {
		this.children = children;
	}

	public ActivityMenuMeta getMeta() {
		return meta;
	}

	public void setMeta(ActivityMenuMeta meta) {
		this.meta = meta;
	}
	
}
