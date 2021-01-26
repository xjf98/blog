package com.xiao.blog.myblog.mapper;

import java.util.List;
import java.util.Map;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.vo.ArticleAndComment;

public interface BlogMapper {

	public List<Article> selectTypeArticle(String categoryId);
	
	public List<Categories> showType();
	
	public Integer getBlogCountsByType(String categoryId);
	
	public List<ArticleAndComment> getArticeByPageModel(Map<String,Object> map);
}
