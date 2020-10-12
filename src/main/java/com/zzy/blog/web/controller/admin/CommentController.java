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
import com.zzy.blog.web.pojo.Comment;
import com.zzy.blog.web.pojo.CommentCustom;
import com.zzy.blog.web.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommentController extends BaseController{


	@Autowired
	private CommentService commentService ;
	
	@SystemLog( optName="后端评论维护跳转")
	@RequestMapping(value = { "/cmtList" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String mdlist(HttpServletRequest request) {
		return "admin/blog/list-comment";
	}
	
	
	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@RequestMapping("/commentAjax")
	@ResponseBody
	public AjaxJson commentAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,String urlId,
			Model model,CommentCustom comment ,HttpServletRequest  request){
		
		PageHelper.startPage(pn, pageNum);
		List<CommentCustom> objList = commentService.findAll(comment ,request);
		PageInfo<CommentCustom> pageInfo = new PageInfo<>(objList, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	
	@SystemLog( optName="后端评论删除操作")
	@RequestMapping(value="/delComment/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public AjaxJson delAll(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "刪除成功";
		try{
			commentService.delCommentByIds(ids);
			return AjaxJson.success("刪除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	
	
	
}
