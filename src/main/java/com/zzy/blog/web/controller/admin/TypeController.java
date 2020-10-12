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
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.service.TypeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TypeController {


	@Autowired
	private TypeService typeService ;
	
	@SystemLog( optName="后端博文分类跳转")
	@RequestMapping(value = { "tplist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String tlist(HttpServletRequest request) {
		return "admin/blog/list-types";
	}
	
	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@RequestMapping("/typesAjax")
	@ResponseBody
	public AjaxJson websiteAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,String urlId,
			Model model,Type type ,HttpServletRequest  request){
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<Type> pics = typeService.findAll(type ,request);
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
	@SystemLog( optName="后端博文分类保存操作")
	@RequestMapping(value = { "/savetype" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(Type object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("保存成功！");
		try {
			typeService.save(object);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("保存失败！");
		}
		return ajax;
	}
	
	/**
	  *       编辑操作取数据
	 * @param department
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/editType/{id}" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson edit(@PathVariable("id") Long id ,
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("查询成功！");
		try {
			Type type = typeService.getTypeById(id);
			Map<String, Object> extend = new HashMap<String, Object>();
			extend.put("object", type);
			ajax.setExtend(extend);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("查询失败！");
		}
		return ajax;
	}
	
	@SystemLog( optName="后端博文分类删除操作")
	@RequestMapping(value="/delType/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public AjaxJson delAll(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "刪除成功";
		try{
			typeService.delTypeByIds(ids);
			return AjaxJson.success("刪除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	
	@RequestMapping(value="/typeIsShow",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson typeIsShow(Long id,HttpServletRequest  request){
		try{
			String msg = "";
			Type type = typeService.getTypeById(id);
			typeService.changeShow(type);
			if(GlobleConstants.Show.IS_SHOW_N.equals(type.getIsShow())){
				msg = "显示设置成功";
			}else{
				msg = "隐藏设置成功";
			}
			return AjaxJson.success(msg);
		}catch(Exception e){
			e.printStackTrace();
		}
		return AjaxJson.success("操作失败");
	}
	//下拉框数据
	@RequestMapping(value = "typeList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson typeList(HttpServletRequest request) {
		List<Type> list = typeService.findAll(null, request);
		log.debug(" 取下拉框数据 ... ...");
		return AjaxJson.success().addData("list", list);
	}
	
	
}
