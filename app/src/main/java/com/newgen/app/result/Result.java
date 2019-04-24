package com.newgen.app.result;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class Result {

	private Integer ret;
	
	private String msg;
	
	private Object data;

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

	@Override
	public String toString() {
		return "Result [ret=" + ret + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
