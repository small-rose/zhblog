package com.zzy.blog.web.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.page.EasyUIDataGrid;
import com.zzy.blog.web.base.page.TreeTableNode;
import com.zzy.blog.web.common.AjaxJson;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.Menu;
import com.zzy.blog.web.pojo.MenuCustom;
import com.zzy.blog.web.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuController {


	@Autowired
	private MenuService menuService ;
	
	@SystemLog( optName="后端菜单维护跳转")
	@RequestMapping(value = { "mlist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String tlist(HttpServletRequest request) {
		return "admin/blog/list-menus";
	}
	@SystemLog( optName="后端树形菜单跳转")
	@RequestMapping(value = { "m2list" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String t2list(HttpServletRequest request) {
		return "admin/blog/list-menus2";
	}
	
	/**
	 * 查询结果数据（分页查询）
	 * @return
	 */
	@SystemLog( optName="后端菜单查询操作")
	@RequestMapping("/menusAjax")
	@ResponseBody
	public AjaxJson websiteAjax(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageNum",defaultValue="5")Integer pageNum,String urlId,
			Model model,MenuCustom menu ,HttpServletRequest  request){
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<MenuCustom> pics = menuService.findAll(menu ,request);
		// 使用pageInfo包装查询结果,只要将pageInfo交给页面
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo<MenuCustom> pageInfo = new PageInfo<>(pics, pageNum);

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
	@SystemLog( optName="后端菜单保存操作")
	@RequestMapping(value = { "/savemenu" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson save(MenuCustom object, 
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("保存成功！");
		try {
			menuService.save(object);
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
	@RequestMapping(value = { "/editMenu/{id}" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxJson edit(@PathVariable("id") Long id ,
			Model model,HttpServletRequest request) throws Exception {
		AjaxJson ajax = new AjaxJson();
		ajax.setMsg("查询成功！");
		try {
			MenuCustom menu = menuService.getMenuCustomById(id);
			Map<String, Object> extend = new HashMap<String, Object>();
			extend.put("object", menu);
			ajax.setExtend(extend);
		} catch (Exception e) {
			e.printStackTrace();
			ajax.setSuccess(false);
			ajax.setMsg("查询失败！");
		}
		return ajax;
	}
	
	@SystemLog( optName="后端菜单删除操作")
	@RequestMapping(value="/delMenu/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public AjaxJson delAll(@PathVariable("ids") Long[] ids,HttpServletRequest  request){
		String msg = "刪除成功";
		try{
			menuService.delMenuByIds(ids);
			return AjaxJson.success("刪除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		return AjaxJson.failed(msg);
	}
	
	@RequestMapping(value="/menuIsShow",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson menuIsShow(Long id,HttpServletRequest  request){
		try{
			String msg = "";
			Menu menu = menuService.getMenuCustomById(id);
			menuService.changeShow(menu);
			if(GlobleConstants.Show.IS_SHOW_N.equals(menu.getIsShow())){
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
	@RequestMapping(value = "/menuList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson menuList(HttpServletRequest request) {
		List<Menu> list = menuService.findList();
		log.debug(" 取下拉框数据 ... ...");
		return AjaxJson.success().addData("list", list);
	}
	

	
	@RequestMapping(value = "/menusTree2")
	@ResponseBody
	public EasyUIDataGrid menusTree(@RequestParam(value="offset",defaultValue="1")Integer pn,@RequestParam(value="limit",defaultValue="5")Integer pageNum,String urlId,
			Model model,MenuCustom menu ,HttpServletRequest  request){
		EasyUIDataGrid list = new EasyUIDataGrid();
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<MenuCustom> customList = menuService.findAll(menu ,request);
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo<MenuCustom> pageInfo = new PageInfo<>(customList, pageNum);
		list.setRows(pageInfo.getList());
		list.setTotal(pageInfo.getTotal());
		return list;
	}
}
