package com.xiao.blog.myblog.service;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.vo.ArticleAndComment;
import com.xiao.blog.myblog.vo.CategoryAndArticle;

public interface ArticleService {

	public List<ArticleAndComment> selectNewArticles();

	public List<CategoryAndArticle> selectCategoryAndArticle();
	
	public List<Article> getPageViewArticle();
}
