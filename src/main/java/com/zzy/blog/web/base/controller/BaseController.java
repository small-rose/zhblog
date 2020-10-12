package com.zzy.blog.web.base.controller;

import java.beans.PropertyEditorSupport;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zzy.blog.web.base.page.Page;
import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.service.SysInfoService;
import com.zzy.blog.web.service.TagService;
import com.zzy.blog.web.service.UserService;


public class BaseController {
	
	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;	
	@Autowired
	private SysInfoService sysInfoService;
	@Autowired
	private TagService tagService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@SuppressWarnings("deprecation")
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
		});
		binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				Date date = DateUtils.parseDate(text);
				setValue(date == null ? null : new Timestamp(date.getTime()));
			}
		});
	}

	public <T> Page<T> getPage(HttpServletRequest request) {
		int pageNo = 1;
		int pageSize = 10;

		String orderBy = "";
		String order = "asc";
		if (StringUtils.isNotEmpty(request.getParameter("page"))) {
			pageNo = Integer.valueOf(request.getParameter("page")).intValue();
		}
		if (StringUtils.isNotEmpty(request.getParameter("rows"))) {
			pageSize = Integer.valueOf(request.getParameter("rows")).intValue();
		}
		if (StringUtils.isNotEmpty(request.getParameter("sort"))) {
			orderBy = request.getParameter("sort").toString();
		}
		if (StringUtils.isNotEmpty(request.getParameter("order"))) {
			order = request.getParameter("order").toString();
		}
		return new Page(pageNo, pageSize, orderBy, order);
	}

	public <T> Map<String, Object> getEasyUIData(Page<T> page) {
		Map<String, Object> map = new HashMap();
		map.put("rows", page.getResult());
		map.put("total", Long.valueOf(page.getTotalCount()));
		map.put("columns", page.getColumns());
		map.put("primaryKey", page.getPrimaryKey());

		return map;
	}
	
	public HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) ra).getRequest();
    }
    
    public HttpServletResponse getResponse(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes) ra).getResponse();
    }
    
	public String getHeader(HttpServletRequest request, String headerName) {
		return request.getHeader(headerName);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getHeaderMap(HttpServletRequest request) {
		Enumeration headerNames = request.getHeaderNames();
		Map headerMap = new HashMap<>();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			headerMap.put(headerName, headerValue);
		}
		return headerMap;
	}

	public String getIpAddress() {
		String ip = this.getRequest().getRemoteAddr();
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

	/**
	 * 获取服务器ip地址
	 * 
	 * @return
	 */
	public String getServerIpAddress() {
		InetAddress address;
		String serverIpAddress = null;
		try {
			address = InetAddress.getLocalHost(); // 获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
			serverIpAddress = address.getHostAddress();// 192.168.0.121
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return serverIpAddress;
	}
}

