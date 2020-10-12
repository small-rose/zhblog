package com.zzy.blog.web.controller.stage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.service.MoodService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainMoodController extends MainBaseController{

	
	@SystemLog( optName="前端心情跳转操作")
	@RequestMapping(value = { "mood" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String mood(HttpServletRequest request) {
		commonHandle(request);
		
		String pageSizeMood = (String) CacheManager.getCacheData(ConfigKey.SHOW_MOOD_SIZE);
		int pageNumSideMood = StringUtils.isNotEmpty(pageSizeMood) ? Integer.parseInt(pageSizeMood) : 10 ; 
		
		PageHelper.startPage(1, pageNumSideMood);
		List<Mood> moodList = moodService.getAllList();
		PageInfo<Mood> pageInfo = new PageInfo<>(moodList, pageNumSideMood);
		request.setAttribute("moodList", pageInfo.getList());
		
		return "stage/lw-mood";
	}
	
	/** 查询心情
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@SystemLog( optName="前端心情查询操作")
	@RequestMapping("/moremood")
	@ResponseBody
	public AjaxJson moremoodAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="10")Integer pageNum,
			Model model,Mood mood ,HttpServletRequest  request){
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		log.info("pn = "+pn+" ,pageNum = "+pageNum);
		PageHelper.startPage(pn, pageNum);
		List<Mood> list = moodService.findAll(mood, request);
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo pageInfo = new PageInfo<>(list, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	/** 心情like操作
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@SystemLog( optName="前端心情点赞操作")
	@RequestMapping("likemood/{id}")
	@ResponseBody
	public AjaxJson likemoodAjax(@PathVariable("id") Long id,
			Model model,Mood mood ,HttpServletRequest  request){
		AjaxJson ajax = new AjaxJson();
		Mood  lastMood = null ;
		try{
			lastMood = moodService.addLike(id);
			ajax.setMsg("感谢");
			ajax.addData("object", lastMood);
		}catch (Exception e) {
			// TODO: handle exception
			ajax.setSuccess(false);
			ajax.setMsg("服务异常");
		}
		return ajax ;
	}
}
