package com.newgen.result;

public class Result {

	private Integer ret;
	
	private String msg;
	
	private Object data;

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
