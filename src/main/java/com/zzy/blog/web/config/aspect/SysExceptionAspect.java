package com.zzy.blog.web.config.aspect;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.RequestUtil;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.SysException;
import com.zzy.blog.web.pojo.SysLog;
import com.zzy.blog.web.pojo.User;
import com.zzy.blog.web.service.SysExceptionService;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(5)
public class SysExceptionAspect {
	 //注入Service用于把日志保存数据库，实际项目入库采用队列做异步
    @Resource
    private SysExceptionService exceptionService;
    
	private SysException exception ;
	
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void exceptionPointCut() {
    	
    }
	
	@Before("exceptionPointCut()")
    public void doBefore(JoinPoint joinPoint) {
		log.debug("-----异常切面 前置通知------------");
		exception = new SysException();
    	exception.setExceptionStarTime(DateUtils.getTime());
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
    	exception.setExceptionUrl(request.getRequestURI());
    	
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent")); 
	    Browser browser = userAgent.getBrowser(); 
	    OperatingSystem os = userAgent.getOperatingSystem();
	    exception.setExceptionRemoteDevice(os.getDeviceType().toString().toLowerCase());
	    String osName = os.getManufacturer().toString().toLowerCase()+ "-" +  os.getName()+ "-" + os.getId();
	    exception.setExceptionOsinfo(osName);
	    String osbr  = browser.getName()+"."+ userAgent.getBrowserVersion()+" | "+ browser.getBrowserType().toString().toLowerCase() +" | "+ browser.getRenderingEngine().toString() ;
	    exception.setExceptionBroswer(osbr);
	    exception.setExceptionRemoteIp(RequestUtil.getClientIp(request));
		
	    exception.setExceptionRemoteUser("guest");
		exception.setExceptionOptnote(request.getMethod());
		if(RequestUtil.isAjaxRequest(request)) {
			exception.setExceptionOptnote(request.getMethod() +" | Ajax");
		}
	}
	
	@After("exceptionPointCut()")
    public void doAfter(JoinPoint joinPoint) {
		log.debug("-----异常切面 后置置通知------------");
		
	}
	
	/**
	 * 拦截web层异常，记录异常日志，并返回友好信息到前端
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     */
    @AfterThrowing(pointcut = "exceptionPointCut()", throwing = "e")
    public void handleThrowing(JoinPoint joinPoint, Throwable e) {
    	log.debug("----- 异常切面捕获  ------AfterThrowing----");
    	try {
	    	e.printStackTrace();
	    	if(e instanceof BussException) {
	    		 log.info(" ------BussException------" +e.getMessage());
	    	}
	    	exception.setExceptionMsg("CauseBy : "+e.getCause() +" ; Msg :" +e.getMessage());
	    	
	       
	        StringBuffer sb = new StringBuffer();
	        String localizedMessage = e.getLocalizedMessage();
			sb.append(" LocalizedMessage : ").append(localizedMessage).append(" ; ");
			Throwable fill = e!=null ? e.fillInStackTrace() : null;
			sb.append(" FillInStackTrace : ").append(fill).append(" ; ");
			
			StackTraceElement[] ele = e!=null ? e.getStackTrace() : null;
			sb.append(" StackTraceElement[").append(ele.length).append("] :");
			for(StackTraceElement ste : ele) {
				//System.out.println(ste.toString());
				sb.append(ste.toString()).append(" \n ");
			}
			sb.append(" ;");
			
			Throwable throwable = e!=null ? e.getCause() : null;
			sb.append(" Throwable : ").append(throwable).append(";");
			exception.setExceptionContent(sb.toString());
			
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
	        HttpSession session = request.getSession();  
	        //读取session中的用户  
	        User user = (User) session.getAttribute(GlobleConstants.LOGIN_USER);  
	        if(user != null) {
	        	exception.setExceptionRemoteUser(user.getRealName());
	        }
	        
        
	        String targetName = joinPoint.getTarget().getClass().getName();  
            String methodName = joinPoint.getSignature().getName();  
           
            String note = targetName +"."+ methodName ;
            if(!exception.getExceptionOptnote().contains(note)) {
            	note = exception.getExceptionOptnote() +" | "+ note ;
            }
            exception.setExceptionOptnote(note);
            
            //保存数据库  
            exception.setExceptionEndTime(DateUtils.getTime());
            
            String expOnff = (String) CacheManager.getCacheData(ConfigKey.SYS_EXCEPTION_ON_OFF);
            if(GlobleConstants.OnOff.IS_ON.equals(expOnff)) {
            	exceptionService.save(exception);  
            	 log.debug("-------------保存异常日志--------------");  
            }
            log.debug("-------------异常通知结束----------");  
        }  catch (Exception ex) {  
            //记录本地异常日志  
        	ex.printStackTrace();
            log.error("--------------异常通知异常--------------");  
            log.error("异常信息:{}", ex.getMessage());  
        }  
         /*==========记录本地异常日志==========*/  
        log.error("异常方法:{}异常代码:{}异常信息:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage());  
  
    }  
}
