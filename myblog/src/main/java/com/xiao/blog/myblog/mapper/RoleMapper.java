package com.xiao.blog.myblog.mapper;

import java.util.List;

import com.xiao.blog.myblog.entity.Role;

public interface RoleMapper {

	public Role getRolesByUser(String username);
}
