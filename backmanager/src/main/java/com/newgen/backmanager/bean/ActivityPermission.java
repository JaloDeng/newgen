package com.newgen.backmanager.bean;

import java.io.Serializable;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:12
 */

public class ActivityPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6880655476951657172L;

	// 主键ID
	private Integer id;
	
	// 名称
	private String name;
	
	// 描述
	private String description;
	
	// 请求网址
	private String url;
	
	// 父节点
	private Integer parentId;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "ActivityPemission [id=" + id + ", name=" + name + ", description=" + description + ", url=" + url
				+ ", parentId=" + parentId + "]";
	}
	
}
