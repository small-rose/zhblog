package com.zzy.blog.web.controller.stage;

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
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Comment;
import com.zzy.blog.web.pojo.CommentCustom;
import com.zzy.blog.web.pojo.Message;
import com.zzy.blog.web.pojo.MessageCustom;
import com.zzy.blog.web.service.CommentService ;
import com.zzy.blog.web.vo.LikeJson;

import lombok.extern.slf4j.Slf4j;

/**
 *  评论处理
 * @author Think
 *
 */
@Slf4j
@Controller
public class MainCommentController {

	@Autowired
	private CommentService commentService;
	
	@SystemLog( optName="前端评论查询操作")
	@RequestMapping("/moreCmt")
	@ResponseBody
	public AjaxJson moreCmt(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			@RequestParam(value="artId")Integer artId, Model model,CommentCustom comment ,HttpServletRequest  request){

		log.info("pn = "+pn+" ,pageNum = "+pageNum);
		comment.setArticleId(Long.valueOf(artId));
		PageHelper.startPage(pn, pageNum);
		List<CommentCustom> msgList = commentService.findAll(comment, request);
		PageInfo<CommentCustom> pageInfo = new PageInfo<>(msgList, pageNum);
		long cmtCount = commentService.countAllCommentByArtId(Long.valueOf(artId));
		return AjaxJson.success().addData("pageInfo", pageInfo).addData("cmtCount", cmtCount);
	}
	
	/**
	  *       保存评论操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="前端评论操作")
	@RequestMapping(value = { "/saveComment" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(@RequestBody CommentCustom object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("评论成功！");
		try {
			Comment comment = commentService.save(object);
			ajax.addData("object", comment);
			long msgcount = commentService.countAllCommentByArtId(comment.getArticleId());
			ajax.addData("msgcount", msgcount);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("评论失败！");
		}
		return ajax;
	}
	
	@SystemLog( optName="前端评论点赞操作")
	@RequestMapping(value="/addPLlike",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson addcmgLike(@RequestBody LikeJson likeJson,HttpServletRequest  request){
		String msg = "操作成功";
		try{
			Comment pl = commentService.addCommentLike(likeJson);
			return AjaxJson.success(msg).addData("object", pl);
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
}
