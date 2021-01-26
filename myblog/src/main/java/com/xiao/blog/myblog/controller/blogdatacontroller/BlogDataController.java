package com.xiao.blog.myblog.controller.blogdatacontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.service.BlogService;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.PageViewModel;

/**
 * 文章相关restcontroller
 * @author feng
 *
 */
@RequestMapping("/blog/data")
@RestController
public class BlogDataController {
	
	@Resource(name="blogService")
	private BlogService blogService;
	
	/**
	 * 文章总数查询
	 */
	@GetMapping("/getBlogCountsbyType")
	public JsonResult getBlogCountsByType(HttpServletRequest request) {
		String categoryId = request.getParameter("categoryId");
		return blogService.getBlogCountsByType(categoryId);
	}
	
	/**
	 * 分页查询文章
	 * @param pageModel
	 * @return
	 */
	@PostMapping("/getArticleByPageModel")
	public JsonResult getArticeByPageModel(@RequestBody PageViewModel pageModel) {
		return blogService.getArticeByPageModel(pageModel);
	}
	
	
	
}
