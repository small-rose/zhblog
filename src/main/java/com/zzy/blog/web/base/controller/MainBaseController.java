package com.zzy.blog.web.base.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.page.Page;
import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.OnlineCounter;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.pojo.Link;
import com.zzy.blog.web.pojo.Menu;
import com.zzy.blog.web.pojo.MenuCustom;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.pojo.SysInfo;
import com.zzy.blog.web.pojo.Tag;
import com.zzy.blog.web.pojo.User;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.CommentService;
import com.zzy.blog.web.service.LinkService;
import com.zzy.blog.web.service.MenuService;
import com.zzy.blog.web.service.MoodService;
import com.zzy.blog.web.service.SysInfoService;
import com.zzy.blog.web.service.TagService;
import com.zzy.blog.web.service.TypeService;
import com.zzy.blog.web.service.UserService;


public class MainBaseController {
	
	public final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected UserService userService;	
	@Autowired
	protected SysInfoService sysInfoService;
	@Autowired
	protected TagService tagService;
	@Autowired
	protected MenuService menuService;
	@Autowired
	protected LinkService linkService;
	@Autowired
	protected MoodService moodService;
	@Autowired
	protected CommentService commentService ;
	@Autowired
	protected BlogService blogService;
	@Autowired
	protected TypeService typeService;
	
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
	
	public void commonHandle(HttpServletRequest request) {
		/*
		User blogUser = userService.getUserInfoById(GlobleConstants.userid);
		request.setAttribute("blogUser", blogUser);
		
		SysInfo sysInfo = sysInfoService.getSysInfoById(GlobleConstants.infoId);
		request.setAttribute("sysInfo", sysInfo);
		*/
		List<Tag> tagList = tagService.getAllList();
		/*for(int i=0 ; i<20; i++) {
			Tag e = new Tag();
			e.setTagName("测试"+i);
			tagList.add(e);
		}*/
		
		request.setAttribute("tagList", tagList);
		
		List<MenuCustom> menuList = menuService.getAllList();
		request.setAttribute("menuList", menuList);
		
		
		String pageSizeLink = (String) CacheManager.getCacheData(ConfigKey.SHOW_SIDEBAR_FLINK_SIZE);
		int pageNumLink = StringUtils.isNotEmpty(pageSizeLink) ? Integer.parseInt(pageSizeLink) : 5 ;
		PageHelper.startPage(1, pageNumLink);
		List<Link> LinkList = linkService.getAllList();
		/*for(int i=0 ; i<50; i++) {
			Link e = new Link();
			e.setLinkName("测试"+i);
			LinkList.add(e);
		}*/
		PageInfo<Link> plList = new PageInfo<>(LinkList,pageNumLink);
		request.setAttribute("linkList", plList.getList());
		//request.setAttribute("linkList", LinkList);
		
		
		String pageSizeMood = (String) CacheManager.getCacheData(ConfigKey.SHOW_SIDEBAR_MOOD_SIZE);
		int pageNumSideMood = StringUtils.isNotEmpty(pageSizeMood) ? Integer.parseInt(pageSizeMood) : 5 ; 
		PageHelper.startPage(1, pageNumSideMood);
		List<Mood> moodList = moodService.getAllList();
		PageInfo<Mood> mdList = new PageInfo<>(moodList, pageNumSideMood);
		request.setAttribute("moodList", mdList.getList());
	}
	
	
	@ModelAttribute
    public void common(HttpServletRequest request, HttpServletResponse response) {
        //执行公共的东西
		log.info("--------------------执行公共的东西--------------------");
		long count = OnlineCounter.getOnline();
		log.info("--------------------count:"+count);
		request.setAttribute("count",count);
		
		User blogUser = userService.getUserInfoById(GlobleConstants.userid);
		request.setAttribute("blogUser", blogUser);
		
		SysInfo sysInfo = sysInfoService.getSysInfoById(GlobleConstants.infoId);
		request.setAttribute("sysInfo", sysInfo);
		
    }
	
}

