package com.xiao.blog.myblog.enums;


public enum ResultStatus {

	SUCCESS(0,"success"),
	FAIL(-1,"fail");
	
	
	private Integer code;
	
	private String msg;
	
	
	ResultStatus(Integer code,String msg){
		this.code = code;
        this.msg = msg;
	}
	
	public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
