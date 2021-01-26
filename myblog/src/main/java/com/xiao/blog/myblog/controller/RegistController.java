package com.xiao.blog.myblog.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.service.RegistService;
import com.xiao.blog.myblog.util.MD5Utils;
import com.xiao.blog.myblog.vo.JsonResult;

@RestController
@RequestMapping("/regist")
public class RegistController {
	
	@Resource(name="registService")
	private RegistService registService;

	
	/**
	 * 注冊用戶的controller
	 * @param user
	 * @return
	 */
	@RequestMapping("/registUser")
	public JsonResult registUser(User user) {
		System.out.println(user.toString());
		return registService.registUser(user);
	}
	
}
