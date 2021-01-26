package com.xiao.blog.myblog.vo;

public class PageViewModel {
	
	private String categoryId;
	
	private Integer currentPage = 1;
	
	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "PageViewModel [categoryId=" + categoryId + ", currentPage=" + currentPage + ", pageSize=" + pageSize
				+ "]";
	}

	
	
	
}
