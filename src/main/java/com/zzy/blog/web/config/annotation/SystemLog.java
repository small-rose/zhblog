package com.zzy.blog.web.config.annotation;

import java.lang.annotation.*;

import com.zzy.blog.web.common.constant.OptionTypeEnum;
/**
 * 
 * @ClassName:  SystemControllerLog   
 * @Description:TODO( 自定义注解，拦截controller )   
 * @author: 张宗愿
 * @date:   2019年4月6日 下午6:45:31   
 *     
 * @Copyright: 2019 www.zhblog.com Inc. All rights reserved. 
 * 注意：
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented//表明这个注解应该被 javadoc工具记录
public @interface SystemLog {

	
	String optName() default "";

}
