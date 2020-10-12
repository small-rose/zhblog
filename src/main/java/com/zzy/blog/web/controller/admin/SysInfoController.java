package com.zzy.blog.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.SysInfo;
import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.service.SysInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SysInfoController {
	
	@Autowired
	private SysInfoService sysInfoService;
	
	/**
	  *       保存博客信息操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="后端博客信息保存操作")
	@RequestMapping(value = { "/saveinfo" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson saveinfo(SysInfo object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("保存博客信息成功！");
		try {
			log.info(object.toString());
			sysInfoService.update(object);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("保存博客信息失败！");
		}
		return ajax;
	}
	/**
	  *       查询博客信息操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/getSysInfo" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson getSysInfo(SysInfo object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("查询博客信息成功！");
		try {
			SysInfo sysinfo = sysInfoService.getSysInfoById(GlobleConstants.infoId);
			Map<String, Object> extend = new HashMap<String, Object>();
			extend.put("object", sysinfo);
			ajax.setExtend(extend);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("查询博客信息失败！");
		}
		return ajax;
	}
}
