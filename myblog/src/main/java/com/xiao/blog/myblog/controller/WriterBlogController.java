package com.xiao.blog.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.xiao.blog.myblog.entity.Article;
import com.xiao.blog.myblog.entity.Categories;
import com.xiao.blog.myblog.entity.ImgResult;
import com.xiao.blog.myblog.entity.User;
import com.xiao.blog.myblog.service.WriteBlogService;


/**
 * 博客(写)
 * @author feng
 *
 */
@Controller
@RequestMapping("/writeblog")
public class WriterBlogController {
	
	@Resource(name="writeBlogService")
	private WriteBlogService writeBlogService;
	

	
	/**
	 * 写博客
	 * @param article
	 * @return
	 */
	@RequestMapping("/addblog")
	public String addBlog(Article article,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
	    writeBlogService.addBlog(article,user);
		return "/writerblog/testArea";
	}
	
	
	
	@RequestMapping("/showType")
	public void showType(HttpServletResponse response) throws IOException {
		List<Categories> showType = writeBlogService.showType();
		response.setCharacterEncoding("UTF-8");
		String jsonString = JSON.toJSONString(showType);
		response.getWriter().print(jsonString);
	}
	
	
	/**
     * 富文本编辑器图片上传
     * @param file
     * @return
	 * @throws IOException 
     */
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public void uploadImage(@RequestParam("upload")MultipartFile file,HttpServletResponse response,HttpServletRequest request) throws IOException
    {
    	
    	System.out.println("==========");
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter(); 
       // CKEditor提交的很重要的一个参数 ,回调函数的序号
        String callback = request.getParameter("CKEditorFuncNum");
        String desFilePath = "";
		String oriName = "";
		ImgResult result = new ImgResult();
		Map<String, String> dataMap = new HashMap<>();
		ImgResult imgResult = new ImgResult();
		try {
			// 1.获取原文件名
			oriName = file.getOriginalFilename();
			// 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
			String extName = oriName.substring(oriName.lastIndexOf("."));
			// 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
			String uuid = UUID.randomUUID().toString();
			String newName = uuid + extName;
			
			// 4.获取要保存的路径文件夹
		//	String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
			//UploadFileUtil.uploadFile(file.getBytes(), uploadDir, newName);
		       
			// 5.保存图片
			file.transferTo(new File("E:\\image\\"+newName));
			// 6.返回保存结果信息
			out.println("<script type=\"text/javascript\">");  
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback  
			 + ",'" +"/"+newName+"','')");  
			out.println("</script>");
		
		} catch (IllegalStateException e) {
			imgResult.setCode(1);
			System.out.println(desFilePath + "图片保存失败");
			String jsonString = JSON.toJSONString(imgResult);
			response.getWriter().println(jsonString);
			
		} catch (IOException e) {
			imgResult.setCode(1);
			System.out.println(desFilePath + "图片保存失败--IO异常");
			String jsonString = JSON.toJSONString(imgResult);
			response.getWriter().println(jsonString);
		}
}
}

