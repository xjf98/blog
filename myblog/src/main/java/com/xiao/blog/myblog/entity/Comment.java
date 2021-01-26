package com.xiao.blog.myblog.entity;

/**
 * 评论
 * @author asus
 *
 */
public class Comment {

    private String commentId;

    /**
     * 评论的文章id
     */
    private String articleId;

    /**
     * 回复的父id 若是评论则为 0，评论中的回复则为对应评论的id
     */
    private String pId;

    /**
     * 评论者
     */
    private String answerId;

    /**
     * 被回复者
     */
    private String respondentId;

    /**
     * 评论日期
     */
    private String commentDate;

    /**
     * 喜欢数
     */
    private int likes=0;

    /**
     * 评论内容
     */
    private String commentContent;

	
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	

	public String getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(String respondentId) {
		this.respondentId = respondentId;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", articleId=" + articleId + ", pId=" + pId + ", answerId="
				+ answerId + ", respondentId=" + respondentId + ", commentDate=" + commentDate + ", likes=" + likes
				+ ", commentContent=" + commentContent + "]";
	}

    
}

