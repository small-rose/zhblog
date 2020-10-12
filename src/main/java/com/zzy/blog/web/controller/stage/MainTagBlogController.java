package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.MoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainTagBlogController extends MainBaseController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private MoodService moodService;
	
	@SystemLog( optName="前端按标签查询博文操作")
	@RequestMapping(value = { "tags/{tagType}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String mood(ArticleCustom record, HttpServletRequest request) {
		commonHandle(request);
		
		PageHelper.startPage(1, 10);
		List<ArticleCustom> List = blogService.findAllArtile(record, request);
		PageInfo<ArticleCustom> pageInfo = new PageInfo<>(List, 10);
		request.setAttribute("moodList", pageInfo.getList());
		
		return "stage/lw-mood";
	}
}
