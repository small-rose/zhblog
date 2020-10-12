package com.zzy.blog.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
@PropertySource("classpath:initValue.properties")//的值是配置文件文件的路径
@ConfigurationProperties(prefix = "init.value")//配置文件前缀
public class InitValueConfig {

	private String upload  ;
}
