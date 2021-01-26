package com.xiao.blog.myblog.vo;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;

public class CategoryAndArticle {

	private String categoryId;
	
	private String categoryName;
	
	private List<Article> articles;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
}
