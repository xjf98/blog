package com.xiao.blog.myblog.service;

import java.util.List;

import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.vo.JsonResult;

public interface AdminService {

	public JsonResult addCategory(Categories category);
	
	public JsonResult showCateGories();
	
	public JsonResult deleteCategory(String categoryId);
	
}
