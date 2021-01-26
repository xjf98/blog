package com.xiao.blog.myblog.service;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.PageViewModel;

public interface BlogService {

	public List<Article> selectTypeArticle(String categoryId);
	
	public List<Categories> showType();
	
	public List<Article> getPhotoArticle();
	
	public JsonResult getBlogCountsByType(String categoryId);
	
	public JsonResult getArticeByPageModel(PageViewModel pageViewModel);
}
