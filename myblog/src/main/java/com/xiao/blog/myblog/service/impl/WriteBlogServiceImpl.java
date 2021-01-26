package com.xiao.blog.myblog.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.mapper.WriteBlogMapper;
import com.xiao.blog.myblog.service.WriteBlogService;
import com.xiao.blog.myblog.util.ResultGeneratorUtils;
import com.xiao.blog.myblog.vo.JsonResult;

@Service("writeBlogService")
@Transactional
public class WriteBlogServiceImpl implements WriteBlogService {

	@Autowired
	private WriteBlogMapper writeBlogMapper;
	
	
	@Override
	public JsonResult addBlog(Article article,User user) {
		
		try {
	    article.setArticleId((UUID.randomUUID().toString()));
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		article.setPubdate(format.format(new Date()));
		String articleContent = article.getArticleContent();
		Pattern p_img = Pattern.compile("(<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>)");
		Matcher matcher = p_img.matcher(articleContent);
		while(matcher.find()) {
			String group = matcher.group(2);
			article.setShowImg(group);
		}
		String replaceContent = articleContent.replaceAll("<[^>]+>", "");
		article.setContent(replaceContent);
		article.setAuthor(user.getUsername());
		writeBlogMapper.addBlog(article);
		
		return ResultGeneratorUtils.success();
		}
		 catch (Exception e) {
			 return ResultGeneratorUtils.error(-1, "发布博文失败");
		}
	}


	@Override
	public List<Categories> showType() {
		return writeBlogMapper.showType();
	}


	/**
	 * 删除一篇博客
	 */
	@Override
	public JsonResult deleteArticle(String articleId) {
		try {
			writeBlogMapper.deleteArticle(articleId);		
			return ResultGeneratorUtils.success();
		} catch (Exception e) {
			return ResultGeneratorUtils.error(-1,"删除博客失败");
		}
	}

}
