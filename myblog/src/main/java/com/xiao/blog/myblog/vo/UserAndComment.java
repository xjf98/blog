package com.xiao.blog.myblog.vo;

import java.util.List;

public class UserAndComment {

	private String commentId;
	
	private String answerId;
	
	private String commentContent;
	
	private String commentDate;
	
	private String username;
	
	private String headImgUrl;
	
	private List<ReplyViewModel> replyList;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
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
	
	

	public List<ReplyViewModel> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyViewModel> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "UserAndComment [commentId=" + commentId + ", answerId=" + answerId + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + ", username=" + username + ", headImgUrl="
				+ headImgUrl + ", replyList=" + replyList + "]";
	}

	
	
	
}
