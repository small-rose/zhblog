package com.zzy.blog.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzy.blog.web.config.InitValueConfig;
import com.zzy.blog.web.service.PictureService;

@Controller
public class DashInfoController {

	@Autowired
	private InitValueConfig initValueConfig;
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value = { "dashInfo" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String dashInfo(HttpServletRequest request) {
		return "admin/blog/list-dash";
	}

}
