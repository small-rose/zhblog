package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Message;
import com.zzy.blog.web.pojo.MessageCustom;
import com.zzy.blog.web.service.MessageService;

@Controller
public class MainSayController extends MainBaseController{
	
	@Autowired
	private MessageService messageService;
	
	
	@SystemLog( optName="前端留言跳转操作")
	@RequestMapping(value = { "say" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String index(HttpServletRequest request) {
		commonHandle(request);
		
		String saySize = (String) CacheManager.getCacheData(ConfigKey.SHOW_SAY_SIZE);
		int sayPageSize = StringUtils.isNotEmpty(saySize) ? Integer.parseInt(saySize)>5 ? Integer.parseInt(saySize): 5 : 5 ;
		
		PageHelper.startPage(1, sayPageSize);
		List<MessageCustom> msgList = messageService.getAllList();
		PageInfo<MessageCustom> pageInfoMsg = new PageInfo<>(msgList, sayPageSize);
		request.setAttribute("msgList", pageInfoMsg.getList());
		
		long msgcount = messageService.countAllSay();
		request.setAttribute("msgcount", msgcount);
		request.setAttribute("sayPageSize", sayPageSize);
		return "stage/lw-say";
	}
	
	@SystemLog( optName="前端留言查询操作")
	@RequestMapping("/moreSay")
	@ResponseBody
	public AjaxJson moreSay(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			Model model,Message message ,HttpServletRequest  request){
		//引入pageHelper分页查询
		log.info("pn = "+pn+" ,pageNum = "+pageNum);
		PageHelper.startPage(pn, pageNum);
		List<MessageCustom> msgList = messageService.getAllList();
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo<MessageCustom> pageInfo = new PageInfo<>(msgList, pageNum);
		long msgcount = messageService.countAllSay();
		return AjaxJson.success().addData("pageInfo", pageInfo).addData("msgcount", msgcount);
	}
	
	/**
	  *       保存操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="前端留言操作")
	@RequestMapping(value = { "/saveMessage" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(Message object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("留言成功！");
		try {
			MessageCustom msg = messageService.save(object);
			ajax.addData("object", msg);
			long msgcount = messageService.countAllSay();
			ajax.addData("msgcount", msgcount);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("留言失败！");
		}
		return ajax;
	}
	
}
