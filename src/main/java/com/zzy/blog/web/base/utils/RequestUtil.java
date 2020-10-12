package com.zzy.blog.web.base.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

	public static String getTmpImg(HttpServletRequest req,String path){
		String imgPath = req.getServletContext().getRealPath("/");
		imgPath += path;
		File filed = new File(imgPath+"/");// 可以是任何
		if (!filed.exists()) {
			filed.mkdirs();
		}
		System.out.println(" imgPath[ "+path+" ] is [ "+ imgPath +" ]");
		return imgPath;
	}
	
	public static String getRootPath(HttpServletRequest request){
		String path = request.getContextPath();
    	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
    	 + path + "/";
    	return basePath;
	}
	
	
	public static String getRemotePort(HttpServletRequest request) {
		String port = String.valueOf(request.getRemotePort());
		return port;
	}
	
	/**
     * 获取客户机的ip地址
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip!=null) {
            	ip =  ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }
    /**
     *   ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }
}
