package com.xiao.blog.myblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.mapper.LoginMapper;
import com.xiao.blog.myblog.service.LoginService;
import com.xiao.blog.myblog.util.MD5Utils;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public User loginUser(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		
		return loginMapper.loginUser(user);
	}

}
