package com.xiao.blog.myblog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xiao.blog.myblog.entity.Role;
import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.entity.UserDetailsImpl;
import com.xiao.blog.myblog.mapper.RoleMapper;
import com.xiao.blog.myblog.mapper.UserMapper;

@Service("userservice")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.findUserByName(username);
		if(user == null) {
			throw new UsernameNotFoundException("无该用户");
		}
	    Role role = roleMapper.getRolesByUser(username);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 authorities.add(new SimpleGrantedAuthority(role.getName()));
	//	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		 return new UserDetailsImpl(user, role);
	}

}
