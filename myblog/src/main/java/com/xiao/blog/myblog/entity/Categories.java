package com.xiao.blog.myblog.entity;

public class Categories {

	private String categoryId;
	
	/**
	 * 分类名称
	 */
	private String categoryName;

	/**
	 * 分类别名
	 */
	private String otherName;
	
	/**
	 * 分类描述
	 */
	private String description;

	

	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}
	

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + ", otherName=" + otherName + ", description="
				+ description + "]";
	}
	
	
	
	
}
