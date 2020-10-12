package com.zzy.blog.web.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.zzy.blog.web.base.utils.OnlineCounter;

@WebListener
public class OnLineUser implements HttpSessionListener{
	
	
    //监听session的创建,synchronized 防并发bug
    public synchronized void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("【HttpSessionListener监听器】count++  增加");
        OnlineCounter.raise();
 
    }
    
    
    public synchronized void sessionDestroyed(HttpSessionEvent arg0) {//监听session的撤销
        System.out.println("【HttpSessionListener监听器】count--  减少");
        OnlineCounter.reduce();
    }
}
