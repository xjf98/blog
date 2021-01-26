package com.xiao.blog.myblog.mapper;

import java.util.List;

import com.xiao.blog.myblog.entity.Reply;
import com.xiao.blog.myblog.vo.ReplyViewModel;


public interface ReplyMapper {
	
	public void writeReply(Reply reply);
	
	public ReplyViewModel getReplyById(String replyContentId);
	
	public List<ReplyViewModel> getAllReplyByCommentId(String commentId);
}
