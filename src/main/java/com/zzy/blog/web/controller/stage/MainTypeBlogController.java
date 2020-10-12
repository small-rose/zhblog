package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.MoodService;
import com.zzy.blog.web.service.TypeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainTypeBlogController extends MainBaseController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private MoodService moodService;
	
	@SystemLog( optName="前端按分类查询博文操作")
	@RequestMapping(value = { "moreTypeArticle" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public AjaxJson moreblogAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			@RequestParam(value="typeId",defaultValue="1")Long typeId,
			Model model,ArticleCustom article ,HttpServletRequest  request){
		
		log.info("pn = "+pn+" ,pageNum = "+pageNum+" ,typeId = "+typeId);
		article.setArticleType(typeId);
		
		PageHelper.startPage(pn, pageNum);
		List<ArticleCustom> list = blogService.findAllArtile(article ,request);
		
		PageInfo<ArticleCustom> pageInfo = new PageInfo<>(list, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
		
	}
}
