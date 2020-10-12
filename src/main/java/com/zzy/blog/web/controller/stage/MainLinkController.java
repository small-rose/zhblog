package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Link;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.LinkService;
import com.zzy.blog.web.service.MoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainLinkController extends MainBaseController{
	

	/**
	  *   flink 友链
	 * @param artId
	 * @param request
	 * @return
	 */
	@SystemLog( optName="前端友链页面跳转")
	@RequestMapping(value = { "/flink" }, method = { RequestMethod.GET })
	public String flink(HttpServletRequest request) {
		
		commonHandle(request);

		String pageSizeImage = (String) CacheManager.getCacheData(ConfigKey.SHOW_FLINK_SIZE);
		int pageNumImage = StringUtils.isNotEmpty(pageSizeImage) ? Integer.parseInt(pageSizeImage) : 10 ;
		if(pageNumImage > 0) {
			PageHelper.startPage(1, pageNumImage);
			List<Link> LinkList = linkService.getAllList();
			PageInfo<Link> plList = new PageInfo<>(LinkList, pageNumImage);
			request.setAttribute("linkList", plList.getList());
		}else {
			List<Link> LinkList = linkService.getAllList();
			request.setAttribute("linkList", LinkList);
		}
		
		return "stage/lw-flink";
	}
	
	
}
