package com.xiao.blog.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.mapper.BlogMapper;
import com.xiao.blog.myblog.service.BlogService;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.ArticleAndComment;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.PageViewModel;

/**
 * 博客相关service
 * @author asus
 *
 */
@Service("blogService")
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	@Override
	public List<Article> selectTypeArticle(String categoryId) {
		List<Article> articles = blogMapper.selectTypeArticle(categoryId);
		return articles;
	}
	
	/**
	 * 加载分类
	 */
	@Override
	public List<Categories> showType() {
		return blogMapper.showType();
	}

	@Override
	public List<Article> getPhotoArticle() {
		return null;
	}


	

	/**
	 * 获取文章的总数
	 */
	@Override
	public JsonResult getBlogCountsByType(String categoryId) {
		Integer blogCounts = blogMapper.getBlogCountsByType(categoryId);
		return ResultGeneratorUtils.success(blogCounts);
	}

	
	/**
	 * 分页分类查询文章
	 */
	@Override
	public JsonResult getArticeByPageModel(PageViewModel pageViewModel) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("categoryId", pageViewModel.getCategoryId());
		map.put("currentPage",( pageViewModel.getCurrentPage()-1)*pageViewModel.getPageSize());
		map.put("pageSize", pageViewModel.getPageSize());
		
		List<ArticleAndComment> articeByPageModel = blogMapper.getArticeByPageModel(map);
	//	JSONArray jsonArray =  (JSONArray) JSONArray.toJSON(articeByPageModel);
		if(articeByPageModel != null) {
		return ResultGeneratorUtils.success( articeByPageModel);
		}
		return ResultGeneratorUtils.error( -1,"分页查询有误");
	}



}
