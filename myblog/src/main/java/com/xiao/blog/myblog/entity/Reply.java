package com.xiao.blog.myblog.entity;
/**
 * 回复实体
 * @author asus
 *
 */
public class Reply {

	private String replyerId;
	private String commentId;
	private String replyContentId;
	private String replyDate;
	private String replyContent;
	private String answerId;
	private String answerName;
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
	@Override
	public String toString() {
		return "Reply [replyerId=" + replyerId + ", commentId=" + commentId + ", replyContentId=" + replyContentId
				+ ", replyDate=" + replyDate + ", replyContent=" + replyContent + ", answerId=" + answerId
				+ ", answerName=" + answerName + "]";
	}
	
	
	
}
