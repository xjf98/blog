package com.xiao.blog.myblog.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.service.AdminArticleService;
import com.xiao.blog.myblog.vo.JsonResult;

@RestController
@RequestMapping("/adminarticle")
public class AdminArticleController {
	
	@Resource(name="adminArticleService")
	private AdminArticleService adminArticleService;

	/**
	 *获取文章总数 
	 */
	@GetMapping("/getAllArticleCount")
	public JsonResult getAllArticleCount() {	
		return adminArticleService.getAllArticleCount();
	}
	
	/**
	 * 获取所有文章
	 * @return
	 */
	@GetMapping("/getAllArticleByPage")
	public JsonResult getAllArticleByPage(@RequestParam("currentPage") Integer currentPage,@RequestParam("count") Integer count) {
		return adminArticleService.getAllArticleByPage(currentPage, count);
	}
}
