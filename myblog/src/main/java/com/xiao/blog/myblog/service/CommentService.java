package com.xiao.blog.myblog.service;

import com.xiao.blog.myblog.entity.Comment;
import com.xiao.blog.myblog.vo.UserAndComment;

public interface CommentService {

	public UserAndComment addComment(Comment comment);
}
