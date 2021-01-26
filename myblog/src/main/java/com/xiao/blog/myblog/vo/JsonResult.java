package com.xiao.blog.myblog.vo;

/**
 * 统一结果返回（json)
 * @author asus
 *
 */
public class JsonResult {
	
	/**
	 * 响应的状态 0.正常   |   -1.错误
	 */
	private  Integer status;
	
	/**
	 * 响应的信息
	 */
	private String msg;
	
	/**
	 * 响应的数据
	 */
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	
	

}
