package com.xiao.blog.myblog.entity;

/**
 * 访客记录
 * @author asus
 *
 */
public class Visitor {

	private Integer id;
	
	/**
	 * 访问的人数
	 */
	private Long visitorNum;
	
	/**
	 * 当前页的文章名
	 */
	private String pageName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getVisitorNum() {
		return visitorNum;
	}

	public void setVisitorNum(Long visitorNum) {
		this.visitorNum = visitorNum;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	
}
