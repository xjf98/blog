package com.xiao.blog.myblog.controller.blogdatacontroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiao.blog.myblog.service.ReplyService;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.WriteReplyViewModel;

@RestController
@RequestMapping("/reply")
public class  ReplyController {

	@Resource(name="replyService")
	private ReplyService replyService;
	
	/**
	 * 将回复存入
	 * @param writeReplyViewModel
	 * @return
	 */
	@PostMapping("/writeReply")
	public JsonResult writReply(@RequestBody WriteReplyViewModel writeReplyViewModel) {
		System.out.println(writeReplyViewModel.toString());
		return replyService.writeReply(writeReplyViewModel);
	}
	
//	/**
//	 * 获取评论下的所有回复
//	 * @return
//	 */
//	public JsonResult getAllReply() {
//		
//		return null;
//	}
	
}
