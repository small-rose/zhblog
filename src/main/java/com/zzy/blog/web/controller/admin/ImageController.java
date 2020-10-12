package com.zzy.blog.web.controller.admin;

import java.io.File;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.BaseController;
import com.zzy.blog.web.base.utils.RequestUtil;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.config.InitValueConfig;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.PicCategorie;
import com.zzy.blog.web.pojo.Picture;
import com.zzy.blog.web.service.ImageCateService;
import com.zzy.blog.web.service.PictureService;
import com.zzy.blog.web.vo.ImageJson;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ImageController extends BaseController{
	
	@Autowired
	private InitValueConfig initValueConfig;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private ImageCateService imageCateService;

	@SystemLog( optName="后端图片库跳转")
	@RequestMapping(value = { "imglist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String index(HttpServletRequest request) {
		log.info(" ... admin/list ....");
		
		List<PicCategorie> list = imageCateService.findAllPicates();
		request.setAttribute("picalist", list);
		return "admin/blog/list-imgs";
	}
	
	/**
	 *  picateAjax 取图片分类信息
	 * @param object
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/picateAjax" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson getPicateList(Picture object, 
			Model model,HttpServletRequest request) throws Exception {
		List<PicCategorie> list = imageCateService.findAllPicates();
		PageInfo<PicCategorie> pageInfo = new PageInfo<>(list);
		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	/** 
	 *   piclist 根据分类图片
	 * @param pn
	 * @param pageNum
	 * @param cateId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/piclist/{cateId}" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson datalist(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,
			@PathVariable("cateId") Long cateId ,HttpServletRequest request) throws Exception {
		List<Picture> list = pictureService.getList(cateId);
		PageInfo<Picture> pageInfo = new PageInfo<>(list);
		
		return AjaxJson.success().addData("pageInfo", pageInfo);
	}
	
	@SystemLog( optName="后端图片重命名操作")
	@RequestMapping(value = { "/rename" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(Picture object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("重命名成功！");
		try {
			int x = pictureService.reName(object);
			if(x == 0) {
				ajax.setSuccess(false);
				ajax.setMsg("重命名失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("重命名失败！");
		}
		return ajax;
	}
	
	
	
	@SystemLog(optName="后端删除图片操作")
	@RequestMapping(value = { "/delImage/{ids}" }, method = { RequestMethod.DELETE })
	@ResponseBody
	public AjaxJson delImage(@PathVariable("ids") Long[] ids ,Picture object, 
			Model model,HttpServletRequest request) throws Exception {
		log.info("--------------------- controller ----------" );
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("删除图片成功！");
		try {
			int x = pictureService.delete(ids);
			if(x == 0) {
				ajax.setSuccess(false);
				ajax.setMsg("没有图片可以删除！");
			}
		} catch (BussException e) {
			//e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg(e.getMessage());
		}
		return ajax;
	}
	
	@SystemLog( optName="后端图片库上传操作")
	@RequestMapping(value = { "/uploadImg" })
	@ResponseBody
	public Map<String, Object> save(MultipartFile uploadFile, Model model,HttpServletRequest request) throws Exception {
		Map<String, Object> ajax = new HashMap<String, Object>();
		try {
			 MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);  
			 String picateId = request.getParameter("picateId");
			 System.out.println("picateId = "+picateId);
			 PicCategorie picCate = imageCateService.getPicCategorieById(Long.valueOf(picateId));
			 ajax.put("picCate", picCate);
			 
			 String path = RequestUtil.getRootPath(request);
			 
			 String rp = request.getSession().getServletContext().getRealPath(initValueConfig.getUpload());
			 System.out.println("rp= "+rp);
			 path += initValueConfig.getUpload();
			 System.out.println("path= "+path);
			 String rootPath = request.getSession().getServletContext().getRealPath("static/img/blog/");
			 System.out.println("rootPath= "+rootPath);
			 
			 
			 List<Picture> result = new ArrayList<>();
			 ImageJson json = null ;
			 String tmpRoot = request.getContextPath();
			 String imgUrl = null;
			 //MultipartFile file = params.getFile("img");
			 List<MultipartFile> files =  ((MultipartRequest) request).getFiles("img");
			 String filepath = "";
			 for(MultipartFile tmpFile : files) {
				 
				 filepath = rootPath + tmpFile.getOriginalFilename();
				 File newFile = new File(filepath); 
		         tmpFile.transferTo(newFile);
		        
		         Picture picture = pictureService.saveWithCategryId(rootPath, tmpFile, picateId);
				 System.out.println("上传成功 "+rootPath);
				 
//				 json = new ImageJson();
//				 json.setImgId(imageId);
//				 imgUrl = tmpRoot+"static/img/blog/"+tmpFile.getOriginalFilename() ;
//				 json.setImgUrl(imgUrl);
				 
				 //ajax.put("imgUrl", imgpath);
				 //ajax.put("imageIds", imageId);
		         result.add(picture);
			 }
			 ajax.put("success", true);
			 ajax.put("result", result);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.put("success", false);
		}
		return ajax;
	}
}
