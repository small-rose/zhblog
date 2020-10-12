package com.zzy.blog.web.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	/**
	 * 配置上传文件大小的配置
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   //  单个数据大小
	   factory.setMaxFileSize("102400KB");
	   /// 总上传数据大小
	   factory.setMaxRequestSize("102400KB");
	   
	   return factory.createMultipartConfig();
	}
}
