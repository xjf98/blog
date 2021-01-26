package com.xiao.blog.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.service.ArticleDetailService;
import com.xiao.blog.myblog.service.ArticleService;
import com.xiao.blog.myblog.vo.ArticleAndComment;

/**
 *所有跳页面路由controller 
 * @author asus
 *
 */
@Controller
public class RouterController {

	@Resource(name="articleService")
	private ArticleService articleService;
	@Resource(name="articleDetailService")
	private ArticleDetailService articleDetailService;
	
	
	/**
	 * 跳转标签归档ui
	 * @return
	 */
	@GetMapping("/categoryUi")
	public String goToCategoryUi() {
		return "blog/category";
	}
	

	/**
	 * 跳转写博客ui
	 * @param request
	 * @return
	 */
	@GetMapping("/towriteUi")
	public String toWriteUi() { 
		return "/writerblog/writerblog";
	}
	
	/**
	 * 跳转文章列表ui
	 * @return
	 */
	@GetMapping("/admin/toadminarticle")
	public String toArticleUi() {
		return "/admin/admin-article";
	}
	
	/**
	 * 跳转文章分类ui
	 * @return
	 */
	@GetMapping("/admin/toadmincategory")
	public String toCategoryUi() {
		return "/admin/admin-category";
	}
	
	/**
	 * 跳转友链页面
	 * @return
	 */
	@GetMapping("/admin/toFlink")
	public String toFlink() {
		return "/admin/flink";
	}
	
	/**
	 * 跳转友链页面
	 * @return
	 */
	@GetMapping("/admin/toadmintag")
	public String toadmintag() {
		return "/admin/admin-tag";
	}
	
	/**
	 * 跳转博客详情
	 * @param articleId
	 * @return
	 */
	@GetMapping("/todetailShow")
	public String toBlogDetailShow(@RequestParam String articleId,Model model) {
		Article article = articleDetailService.articleDetailShow(articleId);
		List<ArticleAndComment> selectNewArticles = articleService.selectNewArticles();
		List<Article> pageViewArticle = articleService.getPageViewArticle();
		
		model.addAttribute("pageViewArticle", pageViewArticle);
		model.addAttribute("newList", selectNewArticles);
		model.addAttribute("article", article);
		return "blog/blog";
	}
}
