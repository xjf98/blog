package com.xiao.blog.myblog.service;

import com.xiao.blog.myblog.vo.JsonResult;

public interface AdminArticleService {

	public JsonResult getAllArticleCount();
	
	public JsonResult getAllArticleByPage(Integer currentPage,Integer count);
}
