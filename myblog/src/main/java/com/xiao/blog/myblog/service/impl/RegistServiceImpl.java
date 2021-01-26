package com.xiao.blog.myblog.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.mapper.RegistMapper;
import com.xiao.blog.myblog.service.RegistService;
import com.xiao.blog.myblog.util.MD5Utils;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.JsonResult;


/**
 * 注冊用戶模块
 * @author asus
 *
 */
@Service("registService")
@Transactional
public class RegistServiceImpl implements RegistService {
	
	@Autowired
	private RegistMapper registMapper;

	/**
	 * 注册用户
	 */
	@Override
	public JsonResult registUser(User user) {
		
		if(user.getUsername() == null || user.getUsername().trim() == "") {
			return ResultGeneratorUtils.error(-1,"用户名出错");
		}
		user.setPassword(MD5Utils.md5(user.getPassword()));
		user.setUid(UUID.randomUUID().toString());
		user.setRole_id(3);
		registMapper.registUser(user);
		return ResultGeneratorUtils.success();
	}

	
}
