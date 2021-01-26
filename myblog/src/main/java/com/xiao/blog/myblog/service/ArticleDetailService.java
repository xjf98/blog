package com.xiao.blog.myblog.service;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.UserAndComment;

public interface ArticleDetailService {

	public Article articleDetailShow(String articleid);

	public JsonResult getAllCommentByArticleId(String articleId);
}
