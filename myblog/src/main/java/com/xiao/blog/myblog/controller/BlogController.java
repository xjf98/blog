package com.xiao.blog.myblog.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.service.ArticleService;
import com.xiao.blog.myblog.service.BlogService;
import com.xiao.blog.myblog.vo.ArticleAndComment;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.PageViewModel;

/**
 * 博文相关
 * @author feng
 *
 */
@RequestMapping("/blog")
@Controller
public class BlogController {

	
	@Resource(name="blogService")
	private BlogService blogService;
	
	@Resource(name="articleService")
	private ArticleService articleService;
	/**
	 * 文章类型内容
	 * @return
	 */
	@RequestMapping("/showTypeArticle")
	public String showTypeArticle(HttpServletRequest request,Model model) {	
		String categoryId = request.getParameter("categoryId");
		List<Article> articles = blogService.selectTypeArticle(categoryId);
		List<Article> pageViewArticle = articleService.getPageViewArticle();
		 List<ArticleAndComment> selectNewArticles = articleService.selectNewArticles();
		//model.addAttribute("articles", articles);
		model.addAttribute("pageViewArticle", pageViewArticle);
		model.addAttribute("selectNewArticles", selectNewArticles);
		model.addAttribute("categoryId", categoryId);
		return "blog/type";
	}
	
	
	/**
	 * 加载分类
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/showType")
	public void showType(HttpServletResponse response) throws IOException {
		List<Categories> showType = blogService.showType();
		String jsonString = JSON.toJSONString(showType);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonString);
	}
	
	/**
	 * 图文推荐
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/photoArticle")
	public void photoArticle(HttpServletResponse response) throws IOException {
		List<Article> photoArticle = blogService.getPhotoArticle();
		String jsonString = JSON.toJSONString(photoArticle);
	}
	
	

	
}
