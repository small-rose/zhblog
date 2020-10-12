package com.zzy.blog.web.controller.simple;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.base.enums.SysThemesEnum;
import com.zzy.blog.web.base.utils.CookieUtil;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.TypeService;

import lombok.extern.slf4j.Slf4j;

 
public class SimpleMainController extends MainBaseController {
	
	
	//@SystemLog(optName="简版前端首页访问")
	//@RequestMapping("/")
	public String index(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			@RequestParam(value="t",defaultValue="0")Long typeId,ArticleCustom articleCustom, 
			HttpServletRequest request, HttpServletResponse response) {
		
		
		SysThemesEnum sysTheme = CookieUtil.getSysTheme(request);
		if(!"simple".equals(sysTheme.getStyle())){
			commonHandle(request);
		}
		Cookie cookie = new Cookie("JEECGINDEXSTYLE", sysTheme.getStyle());
		//设置cookie有效期为一个月
		cookie.setMaxAge(3600*24*30);
		response.addCookie(cookie);

		Cookie zIndexCookie = new Cookie("ZINDEXNUMBER", "1990");
		zIndexCookie.setMaxAge(3600*24*7);//一天
		response.addCookie(zIndexCookie);
		
		if(typeId== 0) {
			getIndexData(pn, pageNum, articleCustom, request);
		
		}else {
			getDataByType(typeId,request);
			return "stage/lw-type-article";
		}
		return "index";
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
	
	
}
