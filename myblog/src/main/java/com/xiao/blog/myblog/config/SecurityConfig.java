package com.xiao.blog.myblog.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.xiao.blog.myblog.service.UserService;
import com.xiao.blog.myblog.service.impl.UserServiceImpl;
import com.xiao.blog.myblog.util.MD5Utils;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		 
		@Bean
		public UserDetailsService userService(){ 
		    return new UserServiceImpl();
		}

	   @Override
	    protected void configure(HttpSecurity http) throws Exception {	
		        http .authorizeRequests()
               .antMatchers("/","/blog/**","/detail/**","/login")
               .permitAll()
               .antMatchers("/writeblog/**","/towriteUi").hasAnyRole("用户","超级管理员")
               .antMatchers("/admin/**","/adminarticle/**").hasAnyRole("超级管理员")
               .and()
               .formLogin().loginPage("/tologin").loginProcessingUrl("/login") .failureUrl("/login/error")
               .and()
               .logout().logoutUrl("/loginout").logoutSuccessUrl("/")
               .and()
		 	   .csrf().disable();
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userService()).passwordEncoder(new Md5PasswordEncoder());
//	        auth
//	            .inMemoryAuthentication()
//	            .withUser("root")
//	            .password("root")
//	            .roles("USER");
	    }
}
