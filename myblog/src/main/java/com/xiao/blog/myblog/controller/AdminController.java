package com.xiao.blog.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.service.AdminService;
import com.xiao.blog.myblog.vo.JsonResult;

/**
 * 管理员模块controller
 * @author asus
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Resource(name="adminService")
	private AdminService adminService;
	
	/**
	 * 获取分类管理信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/getCategoryData")
	public JsonResult getCategoryData() {
		return adminService.showCateGories();
	}
	
	/**
	 * 添加新分类
	 * @return
	 */
	@PostMapping("/addcategory")
	public JsonResult addCategory( Categories category) {
		return adminService.addCategory(category);
	}
	
	/**
	 * 删除分类
	 */
	@PostMapping("/deleteCategory")
	public JsonResult deleteCategory(@RequestParam(value="id") String categoryId) {
		return adminService.deleteCategory(categoryId);	
	}
}
