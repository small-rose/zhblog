package com.zzy.blog.web.base.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zzy.blog.web.pojo.User;

public class SessionUtils {

	
    private static final String SESSION_USER = "session_user";
 
    private static final String SESSION_VALIDATECODE = "session_validatecode";//验证码
 
 
    private static final String SESSION_ACCESS_URLS = "session_access_urls"; //系统能够访问的URL
 
 
    private static final String SESSION_MENUBTN_MAP = "session_menubtn_map"; //系统菜单按钮
 
 
    /**
     * 设置session的值
     * @param request
     * @param key
     * @param value
     */
    public static void setAttr(HttpServletRequest request,String key,Object value){
        request.getSession(true).setAttribute(key, value);
    }
 
 
    /**
     * 获取session的值
     * @param request
     * @param key
     */
    public static Object getAttr(HttpServletRequest request,String key){
        return request.getSession(true).getAttribute(key);
    }
 
    /**
     * 删除Session值
     * @param request
     * @param key
     */
    public static void removeAttr(HttpServletRequest request,String key){
        request.getSession(true).removeAttribute(key);
    }
 
    /**
     * 设置用户信息 到session
     * @param request
     * @param user
     */
    public static void setUser(HttpServletRequest request, User user){
        request.getSession(true).setAttribute(SESSION_USER, user);
    }
 
 
    /**
     * 从session中获取用户信息
     * @param request
     * @return SysUser
     */
    public static User getUser(HttpServletRequest request){
        return (User)request.getSession(true).getAttribute(SESSION_USER);
    }
 
 
    /**
     * 从session中删除用户信息
     * @param request
     * @return SysUser
     */
    public static void removeUser(HttpServletRequest request){
        removeAttr(request, SESSION_USER);
    }
 
 
    /**
     * 设置验证码 到session
     * @param request
     * @param validateCode
     */
    public static void setValidateCode(HttpServletRequest request,String validateCode){
        request.getSession(true).setAttribute(SESSION_VALIDATECODE, validateCode);
    }
 
 
    /**
     * 从session中获取验证码
     * @param request
     * @return SysUser
     */
    public static String getValidateCode(HttpServletRequest request){
        return (String)request.getSession(true).getAttribute(SESSION_VALIDATECODE);
    }
 
 
    /**
     * 从session中获删除验证码
     * @param request
     * @return SysUser
     */
    public static void removeValidateCode(HttpServletRequest request){
        removeAttr(request, SESSION_VALIDATECODE);
    }
 
    /**
     * 判断当前登录用户是否超级管理员
     * @param request
     * @return
     */
    public static boolean isAdmin(HttpServletRequest request){ //判断登录用户是否超级管理员
        User user =  getUser(request);
        /*if(user == null  || !SuperAdmin.YES.key.endsWith(user.getIsSuperAdmin())){
            return false;
        }*/
        return true;
    }
 
    /**
     *设置当前用户可以访问的urls
     * @param request
     * @param accessUrls
     */
    public static void setAccessUrl(HttpServletRequest request,List<String> accessUrls){
        setAttr(request, SESSION_ACCESS_URLS, accessUrls);
    }
 
 
 
    /**
     * 判断URL是否可访问
     * @param request
     * @return
     */
    public static boolean isAccessUrl(HttpServletRequest request,String url){
        List<String> accessUrls = (List)getAttr(request, SESSION_ACCESS_URLS);
        if(accessUrls == null ||accessUrls.isEmpty() || !accessUrls.contains(url)){
            return false;
        }
        return true;
    }
 
 
    /**
     * 设置菜单按钮
     * @param request
     * @param btnMap
     */
    public static void setMemuBtnMap(HttpServletRequest request,Map<String,Object> btnMap){ //判断登录用户是否超级管理员
        setAttr(request, SESSION_MENUBTN_MAP, btnMap);
    }
 
    /**
     * 获取菜单按钮
     * @param request
     * @param menuUri
     */
    public static List<String> getMemuBtnListVal(HttpServletRequest request,String menuUri){
        Map btnMap  = (Map)getAttr(request, SESSION_MENUBTN_MAP);
        if(btnMap == null || btnMap.isEmpty()){
            return null;
        }
        return (List<String>)btnMap.get(menuUri);
    }
}
