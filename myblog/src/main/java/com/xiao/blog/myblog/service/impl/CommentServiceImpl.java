package com.xiao.blog.myblog.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.Comment;
import com.xiao.blog.myblog.mapper.CommentMapper;
import com.xiao.blog.myblog.service.CommentService;
import com.xiao.blog.myblog.vo.UserAndComment;



/**
 * 评论模块
 * @author asus
 *
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;

	/**
	 * 增加评论
	 */
	@Override
	public UserAndComment addComment(Comment comment) {
		comment.setCommentId(UUID.randomUUID().toString());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		comment.setCommentDate(format.format(new Date()));
		System.out.println(comment);
		commentMapper.addComment(comment);
		UserAndComment userAndComment = commentMapper.getUserAndComment(comment.getCommentId());
		return userAndComment;
	}

}
