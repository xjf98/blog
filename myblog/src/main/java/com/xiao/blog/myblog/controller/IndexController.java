package com.xiao.blog.myblog.controller;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.service.ArticleService;
import com.xiao.blog.myblog.vo.ArticleAndComment;
import com.xiao.blog.myblog.vo.CategoryAndArticle;

@Controller
public class IndexController {

	@Resource(name="articleService")
	private ArticleService articleService;
	
	/**
	 * 首页显示
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model) {
		List<ArticleAndComment> selectNewArticles = articleService.selectNewArticles();
		List<CategoryAndArticle> selectCategoryAndArticle = articleService.selectCategoryAndArticle();
		List<Article> pageViewArticle = articleService.getPageViewArticle();
		model.addAttribute("newList", selectNewArticles);
		model.addAttribute("selectCategoryAndArticle", selectCategoryAndArticle);
		model.addAttribute("pageViewArticle", pageViewArticle);
		return "/index";
	}
	
	
	
	
}
