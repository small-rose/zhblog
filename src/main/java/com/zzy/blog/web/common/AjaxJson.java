package com.zzy.blog.web.common;

import java.util.HashMap;
import java.util.Map;

import com.zzy.blog.web.base.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AjaxJson {

	private String code;
	private boolean success = true;
	private String msg;
	
	// 查询数据
	private Map<String, Object> extend = new HashMap<String, Object>();

	public String toString() {
		return " code : " + code + ", msg : " + msg + ", Map :" + extend;
	}


	public AjaxJson addData(String key, Object obj) {
		this.getExtend().put(key, obj);
		return this;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}


	public static AjaxJson success() {
		AjaxJson ajax = new AjaxJson();
		ajax.setCode("200");
		ajax.setMsg("处理成功");
		return ajax;
	}
	
	public static AjaxJson success(String msg) {
		AjaxJson ajax = new AjaxJson();
		ajax.setCode("200");
		if(StringUtils.isEmpty(msg)){
			msg = "处理成功";
		}
		ajax.setMsg(msg);
		return ajax;
	}
	
	public static AjaxJson failed() {
		AjaxJson ajax = new AjaxJson();
		ajax.setCode("100");
		ajax.success = false;
		ajax.setMsg("处理成功");
		return ajax;
	}

	public static AjaxJson failed(String msg) {
		AjaxJson ajax = new AjaxJson();
		ajax.setCode("100");
		ajax.success = false;
		if(StringUtils.isEmpty(msg)){
			msg = "处理失败";
		}
		ajax.setMsg(msg);
		return ajax;
	}
	

}
