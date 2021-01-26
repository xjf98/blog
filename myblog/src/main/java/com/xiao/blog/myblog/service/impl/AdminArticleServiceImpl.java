package com.xiao.blog.myblog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.blog.myblog.mapper.AdminArticleMapper;
import com.xiao.blog.myblog.service.AdminArticleService;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.AdminBlogViewModel;
import com.xiao.blog.myblog.vo.JsonResult;

@Service("adminArticleService")
public class AdminArticleServiceImpl implements AdminArticleService {

	@Autowired
	private AdminArticleMapper adminArticleMapper;
	
	/**
	 *获取文章总数 
	 */
	@Override
	public JsonResult getAllArticleCount() {
		try {
			Integer allArticleCount = adminArticleMapper.getAllArticleCount();
			return ResultGeneratorUtils.success(allArticleCount);
		} catch (Exception e) {
			return ResultGeneratorUtils.error(-1,"获取博客总数失败");
		}
	}

	/**
	 * 获取全部文章
	 */
	@Override
	public JsonResult getAllArticleByPage(Integer currentPage, Integer count) {
		try {
			Map<String,Object> map = new HashMap<>();
			map.put("pageSize",count);
			map.put("currentPage",( (currentPage-1)*count));
			List<AdminBlogViewModel> allArticleByPage = adminArticleMapper.getAllArticleByPage(map);
			return ResultGeneratorUtils.success(allArticleByPage);		
		} catch (Exception e) {
			return ResultGeneratorUtils.error(-1,"获取文章失败");	
		}
	
	}

}
