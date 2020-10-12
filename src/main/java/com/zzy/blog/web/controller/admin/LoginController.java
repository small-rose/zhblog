package com.zzy.blog.web.controller.admin;

import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzy.blog.web.base.utils.CodeUtil;
import com.zzy.blog.web.base.utils.CryptoUtil;
import com.zzy.blog.web.base.utils.SessionManager;
import com.zzy.blog.web.base.utils.SessionUtils;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.User;
import com.zzy.blog.web.service.UserService;
import com.zzy.blog.web.vo.CheckVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("admin10000")
	public String admin(HttpServletRequest request) {
		log.info(" ... admin ....");
		return "admin/login";
	}
	
	@SystemLog( optName="后端登录系统操作")
	@RequestMapping(value = { "login" }, method = { RequestMethod.POST })
	public String login(HttpServletRequest request, HttpServletResponse response) {
		log.info(" ... login ....");
		String uname = String.valueOf(request.getParameter("uname")).trim();
		String upass = String.valueOf(request.getParameter("upass")).trim();
		log.info(" -----uname :"+uname+" ,upass:"+upass);
		User user = userService.getUserByName(uname);
		if(user==null) {
			request.setAttribute("error","用户不存在！ ");
			return "admin/login";
		}else {
			String md5Password =  CryptoUtil.encodeMD5Salt(upass, CryptoUtil.SALT);//DigestUtils.md5DigestAsHex(upass.getBytes());
			if(!md5Password.equals(user.getPassword())){
				request.setAttribute("error","用户名或密码不对！ ");
				return "admin/login";
			}
		}
		Cookie usernameCookie = new Cookie("uname", user.getRealName());
		//对密码进行 md5 加密
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        Cookie pwdCookie = new Cookie("uppd", md5Password);
        usernameCookie.setMaxAge(60 * 60 * 24);
        pwdCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(usernameCookie);
        response.addCookie(pwdCookie);
		HttpSession session = request.getSession(true);

        Cookie sid = new Cookie(GlobleConstants.SESSION_ID, session.getId());
		response.addCookie(sid);
	
		session.setAttribute(GlobleConstants.LOGIN_USER, user);
		
		request.setAttribute(GlobleConstants.SESSION_KEY, session);
		
		SessionManager.addSession(session);
		//return "admin/blog/admin-index";
		return "admin/blog/index";
	}
	
	@SystemLog( optName="后端退出系统操作")
	@RequestMapping(value = { "logout" }, method = { RequestMethod.GET })
	public String getlogout(HttpServletRequest request, HttpServletResponse response) {
		log.info(" ... logout ....");
		
		Cookie killMyCookie = new Cookie("mycookie",   null);  
        killMyCookie.setMaxAge(0);  
        killMyCookie.setPath("/");  
        response.addCookie(killMyCookie); 
        
        /* 增加切面监控
		HttpSession session = request.getSession();
		SessionManager.delSession(session);
		session.invalidate();
		*/
		
		return "redirect:admin";
	}
	
	//@RequestMapping(value = { "login" }, method = { RequestMethod.GET })
	//public String getlogin(HttpServletRequest request, HttpServletResponse response) {
	//	return "admin/login";
	//}
	
	@RequestMapping("/header")
	public String header(HttpServletRequest request) {
		log.info(" ... ....");
		return "common/header";
	}
	
	/**
	 * 生成验证码
	 */
	@RequestMapping(value = "/getVerify")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		 try {
			  response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
			  response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
			  response.setHeader("Cache-Control", "no-cache");
			  response.setDateHeader("Expire", 0);
			  CodeUtil codeutil = new CodeUtil();
			  Map<String, Object> map = codeutil.generateCodeAndPic();
			  BufferedImage bm = (BufferedImage) map.get("codePic");
			  String code = ((StringBuffer) map.get("code")).toString();
			  log.info(" code :" +code);
			  request.getSession().setAttribute(GlobleConstants.CODE_KEY, code);
			  ImageIO.write(bm, "JPEG", response.getOutputStream());
		 } catch (Exception e) {
			  log.error("获取验证码失败>>>> ", e);
		 }
	}
	
	@RequestMapping(value = { "/ajaxLogin" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson ajaxLogin(@RequestBody CheckVO object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setSuccess(true);
		String code = (String) request.getSession().getAttribute(GlobleConstants.CODE_KEY);
		if(code==null || !code.equals(object.getCode())) {
			ajax.setMsg("验证码错误！");
			ajax.setSuccess(false);
			return ajax;
		}
		
		User user = userService.getUserByName(object.getUname());
		if(user==null) {
			ajax.setMsg("用户不存在！ ");
			ajax.setSuccess(true);
			return ajax;
		}else {
			String md5Password =  CryptoUtil.encodeMD5Salt(object.getUpass(), CryptoUtil.SALT);//DigestUtils.md5DigestAsHex(upass.getBytes());
			log.info(" md5Password :"+md5Password);
			log.info(" up :"+user.getPassword());
			if(!md5Password.equals(user.getPassword())){
				ajax.setMsg("用户名或密码不对！ ");
				ajax.setSuccess(false);
				return ajax;
			}
		}
		HttpSession session = request.getSession(true);
		session.setAttribute(GlobleConstants.LOGIN_USER, user);
		ajax.setMsg("登录成功！");
		return ajax;
	}
	
	
	@SystemLog( optName="后端登录系统操作")
	@RequestMapping(value = { "adminIndex" }, method = { RequestMethod.GET })
	public String adminIndex(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(GlobleConstants.LOGIN_USER);
		
		Cookie usernameCookie = new Cookie("uname", user.getRealName());
		//对密码进行 md5 加密
		String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        Cookie pwdCookie = new Cookie("uppd", md5Password);
        usernameCookie.setMaxAge(60 * 60 * 24);
        pwdCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(usernameCookie);
        response.addCookie(pwdCookie);

        Cookie sid = new Cookie(GlobleConstants.SESSION_ID, session.getId());
		response.addCookie(sid);
		request.setAttribute(GlobleConstants.SESSION_KEY, session);
		SessionManager.addSession(session);
		return "admin/blog/index";
	}
}
