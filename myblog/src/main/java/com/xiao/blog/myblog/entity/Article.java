package com.xiao.blog.myblog.entity;

public class Article {

	/**
	 * 文章id
	 */
	private String articleId;

	/**
	 * 文章的首页显示图片
	 */
	private String showImg;

	/**
	 * 除图片外的正文内容
	 */
	private String content;

	/**
	 * 文章作者
	 */
	private String author;

	/**
	 * 文章原作者
	 */
	private String originalAuthor;

	/**
	 * 文章名
	 */
	private String articleTitle;

	/**
	 * 发布时间
	 */
	private String pubdate;

	/**
	 * 最后一次修改时间
	 */
	private String lastUpdateDate;

	/**
	 * 文章内容
	 */
	private String articleContent;

	/**
	 * 文章标签
	 */
	private String articleTagId;

	/**
	 * 文章类型
	 */
	private String articleType;

	/**
	 * 博客分类
	 */
	private String articleCategories;

	/**
	 * 原文链接
	 */
	private String articleUrl;

	/**
	 * 摘要
	 */
	private String summary;

	/**
	 * 上一篇文章id
	 */
	private String lastArticleId;

	/**
	 * 下一篇文章id
	 */
	private String nextArticleId;
	
	private String categoryId;

	/**
	 * 喜欢数
	 */
	private Integer likes = 0;

	private Integer pageView = 0;

	public Integer getPageView() {
		return pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOriginalAuthor() {
		return originalAuthor;
	}

	public void setOriginalAuthor(String originalAuthor) {
		this.originalAuthor = originalAuthor;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	

	public String getArticleTagId() {
		return articleTagId;
	}

	public void setArticleTagId(String articleTagId) {
		this.articleTagId = articleTagId;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getArticleCategories() {
		return articleCategories;
	}

	public void setArticleCategories(String articleCategories) {
		this.articleCategories = articleCategories;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getShowImg() {
		return showImg;
	}

	public void setShowImg(String showImg) {
		this.showImg = showImg;
	}

	
	
	public String getLastArticleId() {
		return lastArticleId;
	}

	public void setLastArticleId(String lastArticleId) {
		this.lastArticleId = lastArticleId;
	}

	public String getNextArticleId() {
		return nextArticleId;
	}

	public void setNextArticleId(String nextArticleId) {
		this.nextArticleId = nextArticleId;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", showImg=" + showImg + ", content=" + content + ", author="
				+ author + ", originalAuthor=" + originalAuthor + ", articleTitle=" + articleTitle + ", pubdate="
				+ pubdate + ", lastUpdateDate=" + lastUpdateDate + ", articleContent=" + articleContent
				+ ", articleTagId=" + articleTagId + ", articleType=" + articleType + ", articleCategories="
				+ articleCategories + ", articleUrl=" + articleUrl + ", summary=" + summary + ", lastArticleId="
				+ lastArticleId + ", nextArticleId=" + nextArticleId + ", categoryId=" + categoryId + ", likes=" + likes
				+ ", pageView=" + pageView + "]";
	}
	

	

}
