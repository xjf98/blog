package com.xiao.blog.myblog.util;

import com.xiao.blog.myblog.enums.ResultStatus;
import com.xiao.blog.myblog.vo.JsonResult;

/**
 * 统一接口返回结果集构建
 * @author asus
 *
 */
public class ResultGeneratorUtils {
	
	
	/**
	 * 成功返回集
	 * @param data
	 * @return
	 */
	public static JsonResult success(Object data) {
		JsonResult result = new JsonResult();
		result.setStatus(ResultStatus.SUCCESS.getCode());
		result.setMsg(ResultStatus.SUCCESS.getMsg());
		result.setData(data);
		return result;
	}
	
	public static JsonResult success() {
		JsonResult result = new JsonResult();
		result.setStatus(ResultStatus.SUCCESS.getCode());
		result.setMsg(ResultStatus.SUCCESS.getMsg());
		result.setData(null);
		return result;
	}
	
	
	/**
	 * 错误返回集
	 * @param status
	 * @param msg
	 * @return
	 */
	public static JsonResult error(Integer status,String msg) {
		JsonResult result = new JsonResult();
		result.setStatus(status);
		result.setMsg(msg);
		return result;
	}
}
