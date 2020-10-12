package com.zzy.blog.web.config.aspect;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.RequestUtil;
import com.zzy.blog.web.base.utils.SessionManager;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.SysLog;
import com.zzy.blog.web.pojo.User;
import com.zzy.blog.web.service.SysLogService;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(4)
public class SystemLogAspect {
	 //注入Service用于把日志保存数据库，实际项目入库采用队列做异步
    @Resource
    private SysLogService sysLogService;
    
    
    private SysLog syslog ;  
    
	@Pointcut("@annotation(com.zzy.blog.web.config.annotation.SystemLog)")
	public void logPointCut() {
		
    }
	@Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
		log.debug("-----访问日志切面 前置通知------------");
		syslog = new SysLog();
		syslog.setLogStarTime(DateUtils.getDateTime());
		//获取请求参数
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//记录请求内容
		//log.info("URL: " +request.getRequestURL());
		//log.info("HTTP_METHOD: " +request.getMethod());
		//log.info("IP: " +request.getRemoteAddr());
		
		
		syslog.setLogUrl(String.valueOf(request.getRequestURL()));
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent")); 
	    Browser browser = userAgent.getBrowser(); 
	    OperatingSystem os = userAgent.getOperatingSystem();
	    syslog.setLogRemoteDevice(os.getDeviceType().toString().toLowerCase());
	    String osName = os.getManufacturer().toString().toLowerCase()+ "-" +  os.getName()+ "-" + os.getId();
	    syslog.setLogOsinfo(osName);
	    String osbr  = browser.getName()+"."+ userAgent.getBrowserVersion()+" | "+ browser.getBrowserType().toString().toLowerCase() +" | "+ browser.getRenderingEngine().toString() ;
		syslog.setLogBroswer(osbr);
		syslog.setLogRemoteIp(RequestUtil.getClientIp(request));
		syslog.setLogRemotePort(RequestUtil.getRemotePort(request));
		syslog.setLogProtocol(request.getProtocol());
		
		syslog.setLogRemoteRemoteuser("guest");
		syslog.setLogOptnote(request.getMethod());
		
		if(!RequestUtil.isAjaxRequest(request)) {
			
			//获取传入目标方法的参数
	        Object[] args = joinPoint.getArgs();
	        for (int i = 0; i < args.length; i++) {
	            Object o = args[i];
	            if(o instanceof ServletRequest || (o instanceof ServletResponse) || o instanceof MultipartFile){
	                args[i] = o.toString();
	            }
	        }
	        String str = JSONObject.toJSONString(args);
	        //log.info("Args : "+str);
	        syslog.setLogParamOrg(str);
		}else {
			//System.out.println("---ajax----");
			syslog.setLogOptnote(request.getMethod() +" | Ajax");
			
			Map<String, Object> paramMap = new HashMap<>();
			Enumeration<String> enm = request.getParameterNames();
			while (enm.hasMoreElements()) {
			String name = enm.nextElement();
				paramMap.put(name, request.getParameter(name));
				//log.info("param name:{},value:{}",name, request.getParameter(name));
			}
			String mapstr = JSONObject.toJSONString(paramMap);
			//log.info("param "+mapstr);
			syslog.setLogParam(mapstr);;
		}	

		Map<String, Object> headerMap = new HashMap<>();
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			headerMap.put(name, request.getHeader(name));
			//log.info("header name:{},value:{}",name, request.getHeader(name));
		}
		String headstr = JSONObject.toJSONString(headerMap);
		syslog.setLogReqHeader(headstr);;
	}
	
	/**
     	* 最终通知：目标方法调用之后执行的代码（无论目标方法是否出现异常均执行）
     	* 因为方法可能会出现异常，所以不能返回方法的返回值
      * @param jp
     */
	@After("logPointCut()")
    public void doAfter(JoinPoint joinPoint) {
		log.debug("-----访问日志切面 后置通知------------");
         try {  
            
            String targetName = joinPoint.getTarget().getClass().getName();  
            String methodName = joinPoint.getSignature().getName();  
            Object[] arguments = joinPoint.getArgs();  
            Class targetClass = Class.forName(targetName);  
            Method[] methods = targetClass.getMethods();
            String operationName = "";
             for (Method method : methods) {  
                 if (method.getName().equals(methodName)) {  
                    Class[] clazzs = method.getParameterTypes();  
                     if (clazzs.length == arguments.length) {  
                         operationName = method.getAnnotation(SystemLog.class).optName();
                         break;  
                    }  
                }  
            }
           
            syslog.setLogOptnote(syslog.getLogOptnote() +" | "+ operationName);
            syslog.setLogMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
            
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    		HttpServletRequest request = attributes.getRequest();
            User user = (User)request.getSession().getAttribute(GlobleConstants.LOGIN_USER);
            if(user!=null) {
            	System.out.println("---user----" + user.toString());
        		syslog.setLogRemoteRemoteuser(user.getRealName());
            }
            if("getlogout".equals(joinPoint.getSignature().getName())) {
            	//退出系统
            	HttpSession session = request.getSession();
         		SessionManager.delSession(session);
         		session.invalidate();
            }
        }  catch (Exception e) {  
            //记录本地异常日志  
            log.error("==访问日志切面 后置通知发生异常==");  
            log.error("异常信息:{}", e.getMessage());  
        }  
         log.info("-------------访问日志切面 后置通知结束-------------");  
	}
	
	@AfterReturning(returning = "result", pointcut = "logPointCut()")
	public void doAfter(Object result) throws Throwable{//throws Throwable
		//请求处理完成，返回结果
		log.info("RESPONSE : "+result);
		String resp = JSONObject.toJSONString(result);
		syslog.setLogRespBody(resp);
		syslog.setLogEndTime(DateUtils.getDateTime());
		
		String logOnff = (String) CacheManager.getCacheData(ConfigKey.SYS_LOG_ON_OFF);
		//如果开关开启，保存数据库  
		if(GlobleConstants.OnOff.IS_ON.equals(logOnff)) {
	        sysLogService.save(syslog);
	        log.debug("-------------保存访问日志--------------");  
		}
		log.info("-------------访问日志切面 后置返回通知结束---------------");  

	}
}
