package com.xiao.blog.myblog.service;

import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.WriteReplyViewModel;

public interface ReplyService {

	
	public JsonResult writeReply(WriteReplyViewModel writeReplyViewModel);
}
