package com.xiao.blog.myblog.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiao.blog.myblog.entity.Reply;
import com.xiao.blog.myblog.mapper.ReplyMapper;
import com.xiao.blog.myblog.service.ReplyService;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.ReplyViewModel;
import com.xiao.blog.myblog.vo.WriteReplyViewModel;



@Service("replyService")
@Transactional
public class ReplyServiceImpl implements ReplyService{
	
	
	@Autowired
	private ReplyMapper ReplyMapper;

	/**
	 * 将回复存入
	 */
	@Override
	public JsonResult writeReply(WriteReplyViewModel writeReplyViewModel) {
		try {
			Reply reply = new Reply();
		    reply.setAnswerId(writeReplyViewModel.getAnswerId());
		    reply.setCommentId(writeReplyViewModel.getCommentId());
		    reply.setReplyContent(writeReplyViewModel.getReplyContent());
		    reply.setReplyContentId(UUID.randomUUID().toString());
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    reply.setReplyDate(simpleDateFormat.format(new Date()));
		    reply.setReplyerId(writeReplyViewModel.getReplyerId());
		    reply.setAnswerName(writeReplyViewModel.getAnswerName());
		    ReplyMapper.writeReply(reply);
		    
		    ReplyViewModel getReply = ReplyMapper.getReplyById(reply.getReplyContentId());
		    System.out.println(getReply);
			return ResultGeneratorUtils.success(getReply);
		    
		} catch (Exception e) {
	      	e.printStackTrace();
		}
		return ResultGeneratorUtils.error(-1,"评论回写错误");
	
	}

}
