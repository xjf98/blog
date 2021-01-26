package com.xiao.blog.myblog.mapper;

import com.xiao.blog.myblog.entity.Comment;
import com.xiao.blog.myblog.vo.UserAndComment;

public interface CommentMapper {

	public void addComment(Comment comment);
	
	public UserAndComment getUserAndComment(String commentId);
}
