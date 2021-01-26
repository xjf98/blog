package com.xiao.blog.myblog.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;

	
	@RequestMapping("/error")
	public void error(HttpServletRequest request, HttpServletResponse response) {
		 response.setContentType("text/html;charset=utf-8");
		 AuthenticationException exception =
		            (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		 try {
		        response.getWriter().write(exception.toString());
		    }catch (IOException e) {
		        e.printStackTrace();
		    }
	}
}
