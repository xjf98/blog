package com.xiao.blog.myblog.mapper;

import java.util.List;

import com.xiao.blog.myblog.entity.Categories;

public interface AdminMapper {

	public void addCategory(Categories category);
	
    public List<Categories> showCateGories();
    
    public void deleteCategory(String categoryId);
}
