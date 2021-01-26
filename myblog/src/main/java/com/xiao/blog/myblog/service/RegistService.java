package com.xiao.blog.myblog.service;

import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.vo.JsonResult;

/**
 * 注册模块业务
 * @author asus
 *
 */
public interface RegistService {

	public JsonResult registUser(User user);
}
