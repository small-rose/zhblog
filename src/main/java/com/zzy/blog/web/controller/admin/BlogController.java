package com.zzy.blog.web.controller.admin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.controller.BaseController;
import com.zzy.blog.web.base.controller.MainBaseController;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.config.InitValueConfig;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Article;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.pojo.Tag;
import com.zzy.blog.web.service.BlogService;
import com.zzy.blog.web.service.MoodService;
import com.zzy.blog.web.service.TagService;
import com.zzy.blog.web.vo.CustomIds;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BlogController extends MainBaseController{
	@Autowired
	private InitValueConfig initValueConfig;
	@Autowired
	private BlogService blogService;
	@Autowired
	private TagService tagService;
	
	
	@SystemLog( optName="后端博客维护跳转")
	@RequestMapping(value = { "/bglist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String index(HttpServletRequest request) {
		return "admin/blog/list-blog";
	}
	
	/**
	 * 写新文章
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/write" }, method = { RequestMethod.GET })
	public String addForm(HttpServletRequest request) {
		return "admin/blog/input-blog";
	}
	
	
	/**
	 * 编辑文章
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String editForm(Long id,HttpServletRequest request) {
		ArticleCustom vo = blogService.getArticleById(id);
		request.setAttribute("article", vo);
		List<Tag> tagList = tagService.getTagsByArticleId(vo.getId());
		request.setAttribute("tagList", tagList);
		return "admin/blog/edit-blog";
	}
	
	
	/**
	  *      上传图片 保存操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="后端博客上传封面操作")
	@RequestMapping(value = { "/uploadfile" }, method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> uploadfile( @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach, 
			Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		try {
			
	           request.setCharacterEncoding("utf-8");
	           response.setHeader("Content-Type", "text/html");
	           String tmppath = initValueConfig.getUpload();
	           //String rootPath = request.getSession().getServletContext().getRealPath("/static/img/blog/");
	           String rootPath = request.getSession().getServletContext().getRealPath(tmppath);
	           
	           System.out.println("editormd上传图片："+rootPath);

	            /**
	             * 文件路径不存在则需要创建文件路径
	             */
	            File filePath = new File(rootPath);
	            if (!filePath.exists()) {
	                filePath.mkdirs();
	            }

	            // 最终文件名
	            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
	            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
	            
	            map.put("success", 1);
	            map.put("message", "上传成功");
	            String path = request.getContextPath();
	            //map.put("url", path+"/static/img/blog/"+attach.getOriginalFilename());
	            map.put("url", tmppath + attach.getOriginalFilename());
	            //RequestPathUtil.getTmpImg(request, "/static/img/blog/");
	            
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", 0);
			map.put("message", "上传失败");
		}
		return map;
	}
	
	
	/**
	  *       保存操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="后端博客保存操作")
	@RequestMapping(value = { "/saveblog" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(@RequestBody ArticleCustom object,
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("保存信息成功！");
		try {
				blogService.saveArticle(object);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("保存信息失败！");
		}
		return ajax;
	}
	
	/**
	   *        删除操作
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SystemLog( optName="后端博客删除操作")
	@RequestMapping(value = { "/blog/deleteAll" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public AjaxJson delete(@RequestBody CustomIds custId,Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("删除用户信息成功！");
		try {
			
			blogService.delete(custId);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("删除用户信息失败！");
		}
		return ajax;
	}
	

	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@SystemLog( optName="后端博客查询操作")
	@RequestMapping("/blogAjax")
	@ResponseBody
	public AjaxJson websiteAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,String urlId,
			Model model,ArticleCustom article ,HttpServletRequest  request){
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<ArticleCustom> pics = blogService.findAll(article ,request);
		// 使用pageInfo包装查询结果,只要将pageInfo交给页面
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo pageInfo = new PageInfo<>(pics, pageNum);

		return AjaxJson.success().addData("pageInfo", pageInfo);
		
	}
	

	/**
	 * 草稿页面
	 * @param request
	 * @return
	 */
	@SystemLog( optName="后端博文草稿跳转")
	@RequestMapping(value = { "/bgdrft" }, method = { RequestMethod.GET })
	public String bgdrft( HttpServletRequest request) {
		
		return "admin/blog/list-draft";
	}
	
	/**
	 * 自己预览
	 * @param artId
	 * @param request
	 * @return
	 */
	@SystemLog( optName="后端博文预览跳转")
	@RequestMapping(value = { "/viewArticle/{artId}" }, method = { RequestMethod.GET })
	public String viewArticle(@PathVariable("artId") Long artId, HttpServletRequest request) {
		ArticleCustom article = blogService.getArticleById(artId);
		request.setAttribute("article", article);
		commonHandle(request);
			
		Article before = blogService.getPrevArticleById(artId);
		Article after = blogService.getNextArticleById(artId);
		request.setAttribute("before", before);
		request.setAttribute("after", after);
		
		return "stage/view-article";
	}
}
