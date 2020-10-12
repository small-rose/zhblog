package com.zzy.blog.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.BaseController;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Message;
import com.zzy.blog.web.pojo.MessageCustom;
import com.zzy.blog.web.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MessageController extends BaseController{


	@Autowired
	private MessageService messageService ;
	
	@SystemLog( optName="后端留言跳转操作")
	@RequestMapping(value = { "msglist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String mdlist(HttpServletRequest request) {
		return "admin/blog/list-message";
	}
	
	
	
	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@RequestMapping("/messagesAjax")
	@ResponseBody
	public AjaxJson websiteAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,String urlId,
			Model model,Message message ,HttpServletRequest  request){
		//引入pageHelper分页查询
		PageHelper.startPage(pn, pageNum);
		List<Message> pics = messageService.findAll(message ,request);
		
		PageInfo pageInfo = new PageInfo<>(pics, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	
	/**
	  *       博主回复留言
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="后端回复留言操作")
	@RequestMapping(value = { "/returnMessage" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson returnMessage(Message object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("回复留言成功！");
		try {
			messageService.returnMessage(object,request);

		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("回复留言失败！");
		}
		return ajax;
	}
	
	
	@SystemLog( optName="后端删除留言操作")
	@RequestMapping(value="/delMessage/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public AjaxJson delAll(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "刪除成功";
		try{
			messageService.delMessageByIds(ids);
			return AjaxJson.success("刪除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}

	
}
