package com.zzy.blog.web.controller.admin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.zzy.blog.web.base.utils.RequestUtil;
import com.zzy.blog.web.config.InitValueConfig;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.service.PictureService;

@Controller
public class UploadController {

	@Autowired
	private InitValueConfig initValueConfig;
	@Autowired
	private PictureService pictureService;
	
	@SystemLog( optName="后端图片上传操作")
	@RequestMapping(value = { "/upload/img" })
	@ResponseBody
	public Map<String, Object> save(MultipartFile uploadFile, Model model,HttpServletRequest request) throws Exception {
		Map<String, Object> ajax = new HashMap<String, Object>();
		try {
			 MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);  
			 String ud = request.getParameter("reportGroupId");
			 System.out.println(ud);
			 String path = RequestUtil.getRootPath(request);
			 System.out.println("path: "+path);
			 //path += initValueConfig.getUpload();
			 //File f = new File(path);
			 String tmppath =  initValueConfig.getUpload();
			 //String rootPath = request.getSession().getServletContext().getRealPath("/static/img/blog/");
			 String rootPath = request.getSession().getServletContext().getRealPath(tmppath);

			 MultipartFile file = params.getFile("img");
	         //List<MultipartFile> file =  ((MultipartRequest) request).getFiles("img");
	        	
	        	 rootPath += file.getOriginalFilename();
	        	 File newFile = new File(rootPath); 
				 file.transferTo(newFile);
	         //String imgpath = newFile + file.getOriginalFilename() ;
	         //System.out.println(params);
			 System.out.println("上传成功 "+rootPath);
			 Long imageId = pictureService.save(rootPath,file);
			 //ajax.put("imgUrl", imgpath);
			 ajax.put("imageId", imageId);
			 String rootpath = request.getContextPath();
			 //ajax.put("imgUrl", rootpath+"/static/img/blog/"+file.getOriginalFilename());
			 ajax.put("imgUrl", tmppath +file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajax;
	}

}
