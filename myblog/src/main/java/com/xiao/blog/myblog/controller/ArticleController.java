package com.xiao.blog.myblog.controller;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.entity.UserDetailsImpl;
import com.xiao.blog.myblog.service.BlogService;
import com.xiao.blog.myblog.service.WriteBlogService;
import com.xiao.blog.myblog.vo.JsonResult;

@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController{
	
	
	@Resource(name="writeBlogService")
	private WriteBlogService writeBlogService;
	

	/**
	 * 增加博客
	 * @param article
	 * @return
	 */
	@PostMapping("/addblog")
	public JsonResult addBlog(Article article) {
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDetailsImpl.getUser();
		logger.info("当前用户信息" + userDetailsImpl.toString());
		return writeBlogService.addBlog(article, user);
	}
	

	/**
	 * 删除一篇博客
	 * @param article
	 * @return
	 */
	@PostMapping("/deleteArticle")
	public JsonResult deleteArticle(String  articleId) {	
		return writeBlogService.deleteArticle(articleId);
	}
	
	
}
