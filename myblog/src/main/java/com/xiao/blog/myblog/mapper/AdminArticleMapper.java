package com.xiao.blog.myblog.mapper;

import java.util.List;
import java.util.Map;

import com.xiao.blog.myblog.vo.AdminBlogViewModel;

public interface AdminArticleMapper {

	public Integer getAllArticleCount();
	
	public List<AdminBlogViewModel> getAllArticleByPage(Map<String,Object> map);
}
