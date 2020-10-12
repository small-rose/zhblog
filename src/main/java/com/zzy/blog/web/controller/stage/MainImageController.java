package com.zzy.blog.web.controller.stage;

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
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.PicCategorie;
import com.zzy.blog.web.pojo.Picture;
import com.zzy.blog.web.service.ImageCateService;
import com.zzy.blog.web.service.PictureService;

@Controller
public class MainImageController extends MainBaseController{

	@Autowired
	private PictureService pictureService;
	@Autowired
	private ImageCateService imageCateService;
	
	@SystemLog( optName="前端图片库跳转操作")
	@RequestMapping(value = { "image" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String index(HttpServletRequest request) {
		commonHandle(request);
		
		List<PicCategorie> list = imageCateService.findAllPicates();
		request.setAttribute("picalist", list);
		return "stage/lw-images";
	}
	

	@RequestMapping(value = { "/stagepicateAjax" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson getPicateList(Picture object, 
			Model model,HttpServletRequest request) throws Exception {
		List<PicCategorie> list = imageCateService.findAllPicates();
		PageInfo<PicCategorie> pageInfo = new PageInfo<>(list);
		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	@RequestMapping(value = { "/stagepiclist/{cateId}" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson datalist(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="12")Integer pageNum,
			@PathVariable("cateId") Long cateId ,HttpServletRequest request) throws Exception {
		
		String pageSizeImage = (String) CacheManager.getCacheData(ConfigKey.SHOW_IMAGE_SIZE);
		int pageNumImage = StringUtils.isNotEmpty(pageSizeImage) ? Integer.parseInt(pageSizeImage) : pageNum ;
		PageHelper.startPage(1, pageNumImage);
		List<Picture> list = pictureService.getList(cateId);
		PageInfo<Picture> pageInfo = new PageInfo<>(list);
		return AjaxJson.success().addData("pageInfo", pageInfo);
	}

	
}
