package com.zzy.blog.web.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zzy.blog.web.base.utils.SessionUtils;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.pojo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserSecurityInterceptor  implements HandlerInterceptor{

	public static String basePath = "";
	
    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
    	//log.debug(" .......preHandle.......");
		String urlStr = request.getRequestURI();
		HttpSession session = request.getSession(true);
		try {
			basePath = (String) request.getSession().getAttribute("basePath");
			// basePath = (String) request.getAttribute("basePath");
			if (StringUtils.isBlank(basePath) || null==basePath) {
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ path + "/";
				request.getSession().setAttribute("basePath", basePath);

			}
			//log.info("basePath :" + basePath);
			request.setAttribute("basePath", basePath);

			// 获取当前请求的url
			urlStr = request.getRequestURI();
			if (isAdminUrl(urlStr)) {
				//System.out.println(" -- urlStr---" + urlStr);
				User userInfo = (User) session.getAttribute(GlobleConstants.LOGIN_USER);
				System.out.println(" userInfo : " + userInfo);
				if (userInfo == null) {
					response.sendRedirect(request.getContextPath() + "/login");
					return false;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    	log.debug(" .......postHandle.......");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    	basePath = (String) request.getSession().getAttribute("basePath");
    	if(StringUtils.isBlank(basePath)|| null==basePath) {
       		String path = request.getContextPath();
           	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
           	 + path + "/";
           	request.getSession().setAttribute("basePath",basePath);
           	request.setAttribute("basePath", basePath);
       	}
    	//log.debug(" .......afterCompletion.......");
    }
    
    private boolean isPassUrl(String url){
        if( !url.endsWith("/login")
                && !url.endsWith("/logout")
                && !url.endsWith(".js") 
                && !url.endsWith(".css") && !url.endsWith(".png")
                && !url.endsWith(".CSS") && !url.endsWith(".CSS") 
                && !url.endsWith(".jpg") && !url.endsWith(".gif")
                && !url.endsWith(".JPG") && !url.endsWith(".GIF")){
            return true;
        }
        return false;
    }
    
    private static List<String> urlList = new ArrayList<>();
    
    private boolean isAdminUrl(String url) {
    	 for(String temp : urlList) {
    		 if(url.contains(temp)) {
    			return true;
    		 }
    	 }
    	 return false;
    }
    
    @PostConstruct
    private void initUrl() {
    	if(urlList.size()==0) {
    		 //博客
	   		 urlList.add("/bglist");
	   		 urlList.add("/bloglist");
	   		 urlList.add("/write");
	   		 urlList.add("/edit");
	   		 urlList.add("/uploadfile");
	   		 urlList.add("/saveblog");
	   		 urlList.add("/blog/deleteAll");
	   		 urlList.add("/blogAjax");
	   		 
	   		 //分类
	   		 urlList.add("/tplist");
	   		 urlList.add("/typesAjax");
	   		 urlList.add("/savetype");
	   		 urlList.add("/editType");
	   		 urlList.add("/delType");
	   		 urlList.add("/typeIsShow");
	   		 urlList.add("/typeList");
	   		 
	   		 //标签
	   		 urlList.add("/tglist");
	  		 urlList.add("/tagsAjax");
	  		 urlList.add("/savetag");
	  		 urlList.add("/editTag");
	  		 urlList.add("/delTag");
	  		 urlList.add("/isShow");
	  		 urlList.add("/tagList");
	  		 
	  		 //心情
	  		 urlList.add("/mdlist");
	  		 urlList.add("/md2list");
	  		 urlList.add("/moodsAjax");
	  		 urlList.add("/savemood");
	  		 urlList.add("/editMood");
	  		 urlList.add("/delMood");
	  		 
	  		 //留言
	  		 urlList.add("/msglist");
	  		 urlList.add("/messagesAjax");
	  		 //urlList.add("/saveMessage");
	  		 urlList.add("/returnMessage");
	  		 urlList.add("/delMessage");
	  		 urlList.add("/isShow");
	  		 urlList.add("/tagList");
	  		 
	  		 //菜单
	  		 urlList.add("/mlist");
	  		 urlList.add("/m2list");
	  		 urlList.add("/menusAjax");
	  		 urlList.add("/savemenu");
	  		 urlList.add("/editMenu");
	  		 urlList.add("/delMenu");
	  		 urlList.add("/menuIsShow");
	  		 urlList.add("/menusTree2");
	  		 
	  		 //图片库
	  		 urlList.add("/imglist");
	  		 urlList.add("/piclist");
	  		 urlList.add("/rename");
	  		 urlList.add("/picateAjax");
	  		 urlList.add("/delImage");
	  		 
	  		 //博客-博主信息
	  		 urlList.add("/saveinfo");
	  		 urlList.add("/getSysInfo");
	  		 urlList.add("/userconfig");
	  		 urlList.add("/saveuser");
	  		 urlList.add("/getUserInfo");
	  		 
	  		 //上传图片
	  		 urlList.add("/upload/img");
   	 	}
    	log.info("--------init url data-------");
    }
}
