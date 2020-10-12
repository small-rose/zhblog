package com.zzy.blog.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.Link;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.LinkService;
import com.zzy.blog.web.service.MoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LinkController {
	
	@Autowired
	private LinkService linkService;

	/**
	  *   flink 友链
	 * @param artId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/linkList" }, method = { RequestMethod.GET })
	public String flink(HttpServletRequest request) {
		
		return "admin/blog/list-flink";
	}
	
	/** 查询友链
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@SystemLog( optName="前端心情查询操作")
	@RequestMapping("/ajaxLink")
	@ResponseBody
	public AjaxJson ajaxLink(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			Model model,Link link ,HttpServletRequest  request){

		log.info("pn = "+pn+" ,pageNum = "+pageNum);
		PageHelper.startPage(pn, pageNum);
		List<Link> list = linkService.findAll(link, request);
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo<Link> pageInfo = new PageInfo<>(list, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	/**
	  *       保存操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="前端申请友链操作")
	@RequestMapping(value = { "/saveLink" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(@RequestBody Link object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("提交成功！");
		try {
			linkService.save(object);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("提交失败！");
		}
		return ajax;
	}
	
	@RequestMapping(value="editLink/{id}",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson editLink(@PathVariable("id") Long id,HttpServletRequest  request){
		String msg = "查询成功";
		try{
			Link link = linkService.getLinkById(id);
			return AjaxJson.success(msg).addData("object", link);
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	@SystemLog( optName="审核后端友链操作")
	@RequestMapping(value="apprFlag",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson apprFlag(@RequestBody Link object, HttpServletRequest  request){
		String msg = "审核通过";
		try{
			if(object.getApprFlag() == 0) {
				msg = "审核驳回";
			}
			linkService.apprHandle(object);
			return AjaxJson.success(msg);
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	@SystemLog( optName="后端删除友链操作")
	@RequestMapping(value="/delLink/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public AjaxJson delAll(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "刪除成功";
		try{
			linkService.delLinkByIds(ids);
			return AjaxJson.success("刪除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
}
