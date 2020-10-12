package com.zzy.blog.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping(value = { "iconlist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String index(HttpServletRequest request) {
		return "admin/blog/list-icon";
	}
}
