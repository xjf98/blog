package com.xiao.blog.myblog.entity;

/**
 * 标签
 * @author asus
 *
 */
public class Tag {

	/**
	 * 标签id
	 */
    private Long tagId;

    /**
     * 标签名
     */
    private String tagName;


	
	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


    
}
