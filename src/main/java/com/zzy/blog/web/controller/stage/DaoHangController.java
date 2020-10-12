package com.zzy.blog.web.controller.stage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.ArticleCustom;

@Controller
public class DaoHangController extends MainBaseController{


	
	@SystemLog( optName="前端本站页面操作")
	@RequestMapping(value = { "site" }, method = { RequestMethod.GET })
	public String loginGet(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			ArticleCustom articleCustom, HttpServletRequest request) {
		commonHandle(request);
		return "stage/lw-site";
	}
}
