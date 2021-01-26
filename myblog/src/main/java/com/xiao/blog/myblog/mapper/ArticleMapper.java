package com.xiao.blog.myblog.mapper;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.vo.ArticleAndComment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ArticleMapper{

	public List<ArticleAndComment> selectNewArticles();
	
	public List<Categories> selectAllCategory();
	
	public List<Article> selectArticleByCategoryId(String categoryId);
	
	public List<Article> getPageViewArticle();
}
