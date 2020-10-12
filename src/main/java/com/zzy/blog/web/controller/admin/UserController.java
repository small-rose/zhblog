package com.zzy.blog.web.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzy.blog.web.base.utils.CookieUtil;
import com.zzy.blog.web.base.utils.CryptoUtil;
import com.zzy.blog.web.base.utils.SessionManager;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.SysInfo;
import com.zzy.blog.web.pojo.User;
import com.zzy.blog.web.service.SysInfoService;
import com.zzy.blog.web.service.UserService;
import com.zzy.blog.web.vo.CheckVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	
	@Autowired
	private SysInfoService sysInfoService;
	@Autowired
	private UserService userService;
	
	@SystemLog( optName="后端相关配置跳转")
	@RequestMapping("/userconfig")
	public String userconfig(HttpServletRequest request) {
		String sessionId = CookieUtil.getValueByKey(request, GlobleConstants.SESSION_ID);
		HttpSession session = SessionManager.getSession(sessionId);
		if(session==null) {
			//throw new BussException("回话过期！");
		}
		//User user = SessionUtils.getUser(request);
		User user = (User) session .getAttribute(GlobleConstants.LOGIN_USER);
		User blogUser = userService.getUserByName(user.getUserName());
		request.setAttribute("blogUser", blogUser);
		
		SysInfo sysInfo = sysInfoService.getSysInfoById(GlobleConstants.infoId);
		request.setAttribute("sysInfo", sysInfo);
		
		//System.out.println(path);
		
		return "admin/blog/user";
	}
	
	/**
	  *       保存博主用户信息操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="后端修改用户信息操作")
	@RequestMapping(value = { "/saveuser" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson saveuser(User object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("保存博主用户成功！");
		try {
			userService.update(object);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("保存博主用户失败！");
		}
		return ajax;
	}
	/**
	  *       查询博主用户信息操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/getUserInfo" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson getUserInfo(User object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("查询博主用户成功！");
		try {
			HttpSession session = request.getSession();
			User user = (User) session .getAttribute(GlobleConstants.LOGIN_USER);
			User blogUser = userService.getUserByName(user.getUserName());
			Map<String, Object> extend = new HashMap<String, Object>();
			extend.put("object", blogUser);
			ajax.setExtend(extend);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("查询博主用户失败！");
		}
		return ajax;
	}
	
	
	
	@SystemLog( optName="找回密码跳转")
	@RequestMapping("/findpass")
	public String findpass(HttpServletRequest request) {
	 
		return "admin/blog/findpass";
	}
	
	
	
	@RequestMapping(value = { "/checkquestion" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson checkquestion(@RequestBody CheckVO object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		log.info(object.toString());
		String code = (String) request.getSession().getAttribute(GlobleConstants.CODE_KEY);
		log.info(" code :" +code +" , object.getCode():"+object.getCode());
		if(!code.equals(object.getCode())) {
			ajax.setMsg("验证码错误！");
			ajax.setSuccess(false);
			return ajax;
		}
		String mobile = CryptoUtil.encodeMD5Salt(object.getMobile(),CryptoUtil.SALT);
		log.info("mobile"+mobile);
		if(!object.getQs().equals("10") || !"7bfb3189ba602674f8a7b864f8ed4a52".equals(mobile)) {
			ajax.setMsg("验证不合法！001");
			ajax.setSuccess(false);
			return ajax;
		}else {
			String an  = object.getAn();
			if(!an.equals("xunzi")) {
				ajax.setMsg("验证不合法！002");
				ajax.setSuccess(false);
				return ajax;
			}
			System.out.println(an);
			long a = System.currentTimeMillis();
			request.getSession().setAttribute("a", a);
			ajax.setSuccess(true);
			ajax.setMsg("验证成功");
		}
		
		ajax.setSuccess(true);
		return ajax;
	}
	
	@RequestMapping(value = { "/checkSecpass" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson checkSecpass(@RequestBody CheckVO object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setSuccess(true);
		String secpas = CryptoUtil.encodeMD5Salt(object.getSecpass(),CryptoUtil.SALT);
		log.info("secpas:"+secpas );
		if(!"b1836cf6dce192869f2af585fc866190".equals(secpas)) {
			ajax.setSuccess(false);
			ajax.setMsg("二级密码错误！");
		}else {
			ajax.setSuccess(true);
			ajax.setMsg("二级密码OK！");
		}
		return ajax;
	}
	
	@RequestMapping(value = { "/resetPwd" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson resetPwd(@RequestBody CheckVO object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		long a = (Long)request.getSession().getAttribute("a");
		long b = System.currentTimeMillis();
		if((b-a)/1000 > 60) {
			ajax.setSuccess(false);
			ajax.setMsg("重置超时！");
			return ajax;
		}
			String newpass = object.getNewpass();
			String md5Password =  CryptoUtil.encodeMD5Salt(newpass, CryptoUtil.SALT);
			User user = new User();
			user.setId(1l);
			log.info("");
			user.setPassword(md5Password);
			userService.updatePass(user);
			ajax.setMsg("重置成功！");
			ajax.setSuccess(true);
		
		return ajax;
	}
}
