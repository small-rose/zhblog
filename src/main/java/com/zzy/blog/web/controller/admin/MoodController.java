package com.zzy.blog.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.service.MoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MoodController extends BaseController{


	@Autowired
	private MoodService moodService ;
	
	@SystemLog( optName="后端心情维护跳转")
	@RequestMapping(value = { "/mdlist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String mdlist(HttpServletRequest request) {
		return "admin/blog/list-mood";
	}
	
	@SystemLog( optName="后端心情盒子跳转")
	@RequestMapping(value = { "md2list" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String md2list(HttpServletRequest request) {
		
		moodService.getAllList();
		
		return "admin/blog/list-mood_box";
	}
	
	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@RequestMapping("/moodsAjax")
	@ResponseBody
	public AjaxJson websiteAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,String urlId,
			Model model,Mood mood ,HttpServletRequest  request){
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<Mood> pics = moodService.findAll(mood ,request);
		// 使用pageInfo包装查询结果,只要将pageInfo交给页面
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo pageInfo = new PageInfo<>(pics, pageNum);

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
	@SystemLog( optName="后端心情发布操作")
	@RequestMapping(value = { "/savemood" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(Mood object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("保存成功！");
		try {
			moodService.save(object);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("保存失败！");
		}
		return ajax;
	}
	
	/**
	  *       保存操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/editMood/{id}" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson edit(@PathVariable("id") Long id ,
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("查询成功！");
		try {
			Mood mood = moodService.getMoodById(id);
			Map<String, Object> extend = new HashMap<String, Object>();
			extend.put("object", mood);
			ajax.setExtend(extend);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("查询失败！");
		}
		return ajax;
	}
	
	@SystemLog( optName="后端心情删除操作")
	@RequestMapping(value="/delMood/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public AjaxJson delAll(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "刪除成功";
		try{
			moodService.delMoodByIds(ids);
			return AjaxJson.success("刪除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	@SystemLog( optName="心情点赞操作")
	@RequestMapping(value="/addlike",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson addlike(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "操作成功";
		try{
			moodService.delMoodByIds(ids);
			return AjaxJson.success(msg);
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	
}
