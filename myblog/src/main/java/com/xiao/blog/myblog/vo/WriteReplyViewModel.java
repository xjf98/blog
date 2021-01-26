package com.xiao.blog.myblog.vo;

public class WriteReplyViewModel {

	private String answerId;
	
	private String commentId;
	
	private String replyContent;
	
	private String replyerId;

	private String answerName;
	
	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	

	public String getReplyerId() {
		return replyerId;
	}

	public void setReplyerId(String replyerId) {
		this.replyerId = replyerId;
	}
	
	
	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	@Override
	public String toString() {
		return "WriteReplyViewModel [answerId=" + answerId + ", commentId=" + commentId + ", replyContent="
				+ replyContent + ", replyerId=" + replyerId + ", answerName=" + answerName + "]";
	}


}
