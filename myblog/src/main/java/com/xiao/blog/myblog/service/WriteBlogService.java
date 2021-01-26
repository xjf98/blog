package com.xiao.blog.myblog.service;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.vo.JsonResult;

public interface WriteBlogService {

	public JsonResult addBlog(Article article, User user);
	
	public List<Categories> showType();
	
	public JsonResult deleteArticle(String articleId);
}
