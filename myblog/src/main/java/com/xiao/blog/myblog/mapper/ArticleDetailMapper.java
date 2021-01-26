package com.xiao.blog.myblog.mapper;

import java.util.List;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.vo.UserAndComment;

public interface ArticleDetailMapper {

	public Article articleDetailShow(String articleid);
	
	public void addHitByArticleId(String articleId);
	
	public List<UserAndComment> getAllCommentByArticleId(String articleId);
}
