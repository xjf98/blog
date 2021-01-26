package com.xiao.blog.myblog.mapper;

import com.xiao.blog.myblog.entity.User;

public interface UserMapper {

	public User findUserByName(String username);
}
