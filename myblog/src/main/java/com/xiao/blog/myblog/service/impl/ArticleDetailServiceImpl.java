package com.xiao.blog.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.mapper.ArticleDetailMapper;
import com.xiao.blog.myblog.mapper.ReplyMapper;
import com.xiao.blog.myblog.service.ArticleDetailService;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.JsonResult;
import com.xiao.blog.myblog.vo.ReplyViewModel;
import com.xiao.blog.myblog.vo.UserAndComment;

@Service("articleDetailService")
@Transactional
public class ArticleDetailServiceImpl implements ArticleDetailService {

	@Autowired
	private ArticleDetailMapper articleDetailMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	/**
	 * 文章详情
	 */
	@Override
	public Article articleDetailShow(String articleId) {
		articleDetailMapper.addHitByArticleId(articleId);
		Article articleDetailShow = articleDetailMapper.articleDetailShow(articleId);
		return articleDetailShow;
	}
	
	/**
	 * 获取文章所有评论
	 * @return 
	 */
	@Override
	public JsonResult getAllCommentByArticleId(String articleId) {
		try {
			List<UserAndComment> allComments = articleDetailMapper.getAllCommentByArticleId(articleId);		
			for (UserAndComment userAndComment : allComments) {
				List<ReplyViewModel> replyList = replyMapper.getAllReplyByCommentId(userAndComment.getCommentId());
				userAndComment.setReplyList(replyList);
			}		
			return ResultGeneratorUtils.success(allComments);
		} catch (Exception e) {
			return ResultGeneratorUtils.error(-1,"获取评论失败");
		}	
	}

}
