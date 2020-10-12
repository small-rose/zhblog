package com.zzy.blog.web.common.constant;

public enum OptionEnum {
	
	AdminJump ("AdminJump" ,"请求跳转" ),
	AdminQuery ( "AdminQuery", "查询操作" ), 
	AdminSave( "AdminSave" , "保存操作" ), 
	AdminDelete( "AdminDelete" , "删除操作" ), 
	
	
	/**
	 * 前端跳转请求
	 */
	
	StateJumpIndex ("StateJumpIndex", "前端请求首页跳转"), 
	StateJumpBlog ("StateJumpBlog", "前端请求博客跳转"),
	
	StateJumpImage ("StateJumpImage", "前端请求图片库跳转"),
	StateJumpMood ("StateJumpMood", "前端请求心情跳转"),
	
	StateJumpFile ("StateJumpFile", "前端请求存档跳转"),
	StateJumpSite("StateJumpSite", "前端请求本站跳转"),
	StateJumpSay("StateJumpSay", "前端请求留言跳转"),
		
	StateQueryPage("StateQueryPage", "前端分页查询操作"), 
	StateComment("StateComment", "前端评论操作"), 
	StateSay("StateSay", "前端留言操作" );
		
	private String code ;
	private String name ;
	
	private OptionEnum(String code ,String name) {
		this.code = code;
		this.name = name;
	}

	public static String getName(String code) {
		for(OptionEnum option : OptionEnum.values()) {
			if(option.getCode() == code) {
				return option.getName();
			}
		}
		return null;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
