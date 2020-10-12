package com.zzy.blog.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzy.blog.web.base.page.EasyUIDataGrid;
import com.zzy.blog.web.config.annotation.SystemLog;
import com.zzy.blog.web.pojo.MenuCustom;
import com.zzy.blog.web.pojo.SysException;
import com.zzy.blog.web.pojo.SysLog;
import com.zzy.blog.web.service.LogExceptionService;
import com.zzy.blog.web.service.MoodService;

@Controller
public class LogExcetptionController {


	@Autowired
	private LogExceptionService logExceptionService ;
	
	
	@SystemLog( optName="后端日志查询跳转")
	@RequestMapping(value = { "/loglist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String loglist(HttpServletRequest request) {
		return "admin/blog/list-logs";
	}
	
	@SystemLog( optName="后端异常查询跳转")
	@RequestMapping(value = { "/exceptlist" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String exceptlist(HttpServletRequest request) {
		return "admin/blog/list-exception";
	}
	
	@RequestMapping(value = "/logDatagrid")
	@ResponseBody
	public EasyUIDataGrid logDatagrid(@RequestParam(value="offset",defaultValue="1")Integer pn,@RequestParam(value="limit",defaultValue="5")Integer pageNum,String urlId,
			Model model,SysLog syslog ,HttpServletRequest  request){
		EasyUIDataGrid list = new EasyUIDataGrid();
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<SysLog> customList = logExceptionService.findAllSysLog(syslog ,request);
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo<SysLog> pageInfo = new PageInfo<>(customList, pageNum);
		list.setRows(pageInfo.getList());
		list.setTotal(pageInfo.getTotal());
		return list;
	}
	
	
	@RequestMapping(value = "/exceptionDatagrid")
	@ResponseBody
	public EasyUIDataGrid exceptionDatagrid(@RequestParam(value="offset",defaultValue="1")Integer pn,@RequestParam(value="limit",defaultValue="5")Integer pageNum,String urlId,
			Model model,SysException exception ,HttpServletRequest  request){
		EasyUIDataGrid list = new EasyUIDataGrid();
		//引入pageHelper分页查询
		// 查询之前调用，传入页码和每页大小
		PageHelper.startPage(pn, pageNum);
		// startPage后面紧跟查询
		List<SysException> List = logExceptionService.findAllSysException(exception ,request);
		// PageInfo封装了详细的分页信息（包含查询的数据），传入list,连续显示分页数
		PageInfo<SysException> pageInfo = new PageInfo<>(List, pageNum);
		list.setRows(pageInfo.getList());
		list.setTotal(pageInfo.getTotal());
		return list;
	}
}
