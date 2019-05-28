package com.newgen.commons.model;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @date 2019-04-25 09:59
 */

public class Result {

	private Integer ret;
	
	private String msg;
	
	private Object data;
	
	private Integer total;

	public Result() {}
	
	/**
	 * 返回结果集
	 * @param ret 1:成功，0：失败/已存在
	 * @param msg 信息
	 * @param data 数据
	 */
	public Result(Integer ret, String msg, Object data) {
		this.ret = ret;
		this.msg = msg;
		this.data = data;
		this.total = 0;
	}
	
	/**
	 * 返回结果集
	 * @param ret 1:成功，0：失败/已存在
	 * @param msg 信息
	 * @param data 数据
	 * @param total 函数
	 */
	public Result(Integer ret, String msg, Object data, Integer total) {
		this.ret = ret;
		this.msg = msg;
		this.data = data;
		this.total = total;
	}

	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
