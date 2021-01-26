package com.xiao.blog.myblog.mapper;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;

public interface WriteBlogMapper {

	public void addBlog(Article article);
	
	public List<Categories> showType();
	
	public void deleteArticle(String articleId);
}
