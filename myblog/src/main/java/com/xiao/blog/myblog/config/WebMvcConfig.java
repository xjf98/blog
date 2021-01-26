package com.xiao.blog.myblog.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
//	   
//	@Override
//	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		  registry.addResourceHandler("/pages/**").addResourceLocations("classpath:/templates/");
//	    }
//	
	  @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
			System.out.println("烦烦烦");
	        registry.addViewController("/admin").setViewName("admin/admin-article");
	        registry.addViewController("/tologin").setViewName("login/newlogin");
	  }
	
	  
	   @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	        super.addResourceHandlers(registry);
	    }
	
}
