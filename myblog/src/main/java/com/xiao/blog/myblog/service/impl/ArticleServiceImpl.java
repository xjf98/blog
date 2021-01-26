package com.xiao.blog.myblog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.mapper.ArticleMapper;
import com.xiao.blog.myblog.service.ArticleService;
import com.xiao.blog.myblog.vo.ArticleAndComment;
import com.xiao.blog.myblog.vo.CategoryAndArticle;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	/**
	 * 最新文章显示
	 */
	@Override
	public List<ArticleAndComment> selectNewArticles() {
		List<ArticleAndComment> newArticle = articleMapper.selectNewArticles();
		return newArticle;
	}

	/**
	 * 分类列表
	 */
	@Override
	public List<CategoryAndArticle> selectCategoryAndArticle() {
		

		List<CategoryAndArticle> newList = new ArrayList<CategoryAndArticle>();

		List<Categories> selectAllCategory = articleMapper.selectAllCategory();
		for (Categories categories : selectAllCategory) {
			CategoryAndArticle categoryAndArticle = new CategoryAndArticle();
			categoryAndArticle.setCategoryId(categories.getCategoryId());
			categoryAndArticle.setCategoryName(categories.getCategoryName());
			List<Article> selectArticleByCategoryId = articleMapper
					.selectArticleByCategoryId(categories.getCategoryId());
			categoryAndArticle.setArticles(selectArticleByCategoryId);
			newList.add(categoryAndArticle);
		}
		return newList;
	}

	/**
	 * 获取浏览量前9的文章
	 */
	@Override
	public List<Article> getPageViewArticle() {
		List<Article> pageViewArticle = articleMapper.getPageViewArticle();
		return pageViewArticle;
	}

}
