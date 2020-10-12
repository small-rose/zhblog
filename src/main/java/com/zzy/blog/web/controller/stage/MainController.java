package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.BaseController;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.common.constant.OptionTypeEnum;
import com.zzy.blog.web.common.constant.OptionEnum;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Article;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.CommentCustom;
import com.zzy.blog.web.pojo.Link;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.pojo.SysInfo;
import com.zzy.blog.web.pojo.Tag;
import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.pojo.User;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.LinkService;
import com.zzy.blog.web.service.MoodService;
import com.zzy.blog.web.service.SysInfoService;
import com.zzy.blog.web.service.TagService;
import com.zzy.blog.web.service.TypeService;
import com.zzy.blog.web.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName:  MainController   
 * @Description:TODO(主页内容展示取值)   
 * @author: 张宗愿
 * @date:   2019年3月23日 下午1:29:09   
 *     
 * @Copyright: 2019 www.zhblog.com Inc. All rights reserved. 
 * 注意：
 */
@Slf4j
@Controller
public class MainController extends MainBaseController{

	@Autowired
	private BlogService blogService;
	@Autowired
	private TypeService typeService;


	
	@SystemLog( optName="前端首页或分类跳转")
	@RequestMapping(value = { "index" }, method = { RequestMethod.GET })
	public String mainIndex(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			@RequestParam(value="t",defaultValue="0")Long typeId, ArticleCustom articleCustom, HttpServletRequest request) {
		commonHandle(request);
		
		if(typeId== 0) {
			getIndexData(pn, pageNum, articleCustom, request);
		
		}else {
			getDataByType(typeId,request);
			return "stage/lw-type-article";
		}
		
		return "stage/index";
	}
	
	@SystemLog(optName="前端首页或分类跳转")
	@RequestMapping("/")
	public String index(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			@RequestParam(value="t",defaultValue="0")Long typeId,ArticleCustom articleCustom, HttpServletRequest request) {
		commonHandle(request);
		if(typeId== 0) {
			getIndexData(pn, pageNum, articleCustom, request);
		
		}else {
			getDataByType(typeId,request);
			return "stage/lw-type-article";
		}
		return "stage/index";
	}
	
	private void getDataByType(Long typeId, HttpServletRequest request) {
		
		String pageSize = (String) CacheManager.getCacheData(ConfigKey.SHOW_TYPE_ARTICLE_SIZE);
		int pageNum = StringUtils.isNotEmpty(pageSize) ? Integer.parseInt(pageSize) : 5 ; 
		request.setAttribute("pageNum", pageNum);
		
		PageHelper.startPage(1, pageNum );
		List<ArticleCustom> bestlist = blogService.findArtileByType(typeId ,request);
		PageInfo<ArticleCustom> btList = new PageInfo<>(bestlist,pageNum);
		request.setAttribute("tplist", btList.getList());
		
		Type tp = typeService.getTypeById(typeId);
		request.setAttribute("tp", tp);
	}
	
	public void getIndexData(Integer pn,Integer pageNum,ArticleCustom articleCustom, HttpServletRequest request) {
		
		String pageSizeBest = (String) CacheManager.getCacheData(ConfigKey.SHOW_BEST_ARTICLE_SIZE);
		int bestPageNum = StringUtils.isNotEmpty(pageSizeBest) ? Integer.parseInt(pageSizeBest) : 4 ; 
		
		PageHelper.startPage(pn, bestPageNum);
		List<ArticleCustom> bestlist = blogService.findBestArtile(articleCustom ,request);
		PageInfo<ArticleCustom> btList = new PageInfo<>(bestlist,pageNum);
		request.setAttribute("btlist", btList.getList());
		
		// 查询之前调用，传入页码和每页大小
		String pageSize = (String) CacheManager.getCacheData(ConfigKey.SHOW_INDEX_ARTICLE_SIZE);
		pageNum = StringUtils.isNotEmpty(pageSize) ? Integer.parseInt(pageSize) : pageNum ; 
		request.setAttribute("pageNum", pageNum);
		
		PageHelper.startPage(pn, pageNum);
		List<ArticleCustom> list = blogService.findAllArtile(articleCustom ,request);
		PageInfo<ArticleCustom> artList = new PageInfo<>(list,pageNum);
		request.setAttribute("newlist", artList.getList());
	}
	

	@SystemLog(optName="前端存档页面跳转")
	@RequestMapping(value = { "/search" }, method = { RequestMethod.GET })
	public String search(HttpServletRequest request) {
		String key = request.getParameter("key");
		
		return "stage/lw-search";
	}
	
	/**
	 *  file 存档目录
	 * @param artId
	 * @param request
	 * @return
	 */
	@SystemLog(optName="前端存档页面跳转")
	@RequestMapping(value = { "/file" }, method = { RequestMethod.GET })
	public String file(HttpServletRequest request) {
		
		commonHandle(request);
		
		List<ArticleCustom> fileList = blogService.findAllListGroupByYear();
		request.setAttribute("fileList", fileList);
		
		return "stage/lw-file";
	}
	
	
	
}
