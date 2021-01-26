package com.xiao.blog.myblog.vo;

import com.xiao.blog.myblog.entity.Reply;

public class ReplyViewModel {

	
//	private String replyContentId;
//	private String replyDate;
//	private String replyContent;
//	private String username;
//	private String headImgUrl;
	
	private String replyerId;
	private String commentId;
	private String replyContentId;
	private String replyDate;
	private String replyContent;
	private String answerId;
	private String answerName;
	
	private String username;
	private String headImgUrl;
	
	
	
	public String getReplyerId() {
		return replyerId;
	}
	public void setReplyerId(String replyerId) {
		this.replyerId = replyerId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getReplyContentId() {
		return replyContentId;
	}
	public void setReplyContentId(String replyContentId) {
		this.replyContentId = replyContentId;
	}
	public String getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	@Override
	public String toString() {
		return "ReplyViewModel [replyerId=" + replyerId + ", commentId=" + commentId + ", replyContentId="
				+ replyContentId + ", replyDate=" + replyDate + ", replyContent=" + replyContent + ", answerId="
				+ answerId + ", answerName=" + answerName + ", username=" + username + ", headImgUrl=" + headImgUrl
				+ "]";
	}

	
	
	
	
	
}   
    