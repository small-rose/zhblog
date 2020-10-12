package com.zzy.blog.web.base.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.zzy.blog.web.base.enums.SysThemesEnum;



public class CookieUtil {

	/**
	 * 获取系统风格
	 * @param request
	 * @return
	 */
	public static SysThemesEnum getSysTheme(HttpServletRequest request){
		String indexStyle = null;
		try {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
					continue;
				}
				if (cookie.getName().equalsIgnoreCase("JEECGINDEXSTYLE")) {
					indexStyle = cookie.getValue();
				}
			}
		} catch (Exception e) {
		}
		return SysThemesEnum.toEnum(indexStyle);
	}
	
	
	public static  String getValueByKey(HttpServletRequest request, String key){
		Cookie[] cooks = request.getCookies();
		String result = "";
		for(Cookie tmpCook : cooks) {
			if(tmpCook.getName().equals(key)) {
				result = tmpCook.getValue();
			}
		}
		return result;
	}
}
