package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.zzy.blog.web.pojo.Comment;
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
import com.zzy.blog.web.vo.LikeJson;

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
public class MainBlogController extends MainBaseController{

	@Autowired
	private BlogService blogService;
	@Autowired
	private TypeService typeService;

	
	
	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@SystemLog( optName="前端分页查询操作")
	@RequestMapping("/moreblog")
	@ResponseBody
	public AjaxJson moreblogAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			Model model,ArticleCustom article ,HttpServletRequest  request){
		
		log.info("pn = "+pn+" ,pageNum = "+pageNum);
		PageHelper.startPage(pn, pageNum);
		List<ArticleCustom> list = blogService.findAllArtile(article ,request);
		
		PageInfo<ArticleCustom> pageInfo = new PageInfo<>(list, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
		
	}
	
	
	
	/**
	 * 游客点击预览
	 * @param artId
	 * @param request
	 * @return
	 */
	@SystemLog(optName="前端查看博文详细操作")
	@RequestMapping(value = { "/view" }, method = { RequestMethod.GET })
	public String viewAdd1(Long id, HttpServletRequest request) {
		ArticleCustom article = blogService.getArticleById(id);
		request.setAttribute("article", article);
		blogService.addViewHits(article);
		
		commonHandle(request);
		
		Article before = blogService.getPrevArticleById(id);
		Article after = blogService.getNextArticleById(id);
		request.setAttribute("before", before);
		request.setAttribute("after", after);
		
		return "stage/lw-article";
	}
	
	/**
	 * 游客点击预览
	 * @param artId
	 * @param request
	 * @return
	 */
	@SystemLog(optName="固定文章地址访问操作")
	@RequestMapping(value = { "/view/{id}" }, method = { RequestMethod.GET })
	public String viewAdd(@PathVariable("id")Long id, HttpServletRequest request) {
		ArticleCustom article = blogService.getArticleById(id);
		request.setAttribute("article", article);
		blogService.addViewHits(article);
		
		commonHandle(request);
		
		Article before = blogService.getPrevArticleById(id);
		Article after = blogService.getNextArticleById(id);
		request.setAttribute("before", before);
		request.setAttribute("after", after);
		
		return "stage/lw-article";
	}
	
	
	@SystemLog( optName="前端文章点赞操作")
	@RequestMapping(value="/addArtLike",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson addArtLike(@RequestBody LikeJson likeJson,HttpServletRequest  request){
		String msg = "操作成功";
		try{
			Article pl = blogService.addArticleLike(likeJson);
			return AjaxJson.success(msg).addData("object", pl);
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
}
