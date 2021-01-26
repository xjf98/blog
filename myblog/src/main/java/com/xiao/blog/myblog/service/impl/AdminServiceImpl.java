package com.xiao.blog.myblog.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.mapper.AdminMapper;
import com.xiao.blog.myblog.service.AdminService;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.JsonResult;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	/**
	 * 增加分类
	 */
	@Override
	public JsonResult addCategory(Categories category) {
		try {
		category.setCategoryId(UUID.randomUUID().toString());
		adminMapper.addCategory(category);
		return ResultGeneratorUtils.success();
		} catch (Exception e) {
		    e.printStackTrace();
			return ResultGeneratorUtils.error(-1, "添加分类失败");
		}
	}

	/**
	 * 分类数据
	 */
	@Override
	public JsonResult showCateGories() {
		try {
			List<Categories> showCateGories = adminMapper.showCateGories();
			return ResultGeneratorUtils.success(showCateGories);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return ResultGeneratorUtils.error(-1,"获取分类信息失败");
	}

	/**
	 * 删除分类
	 */
	@Override
	public JsonResult deleteCategory(String categoryId) {
		try {
			adminMapper.deleteCategory(categoryId);
			return ResultGeneratorUtils.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultGeneratorUtils.error(-1, "删除失败");
		}
	
	}

}
