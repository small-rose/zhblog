package com.zzy.blog.web.base.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class TreeNode implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String text ; //节点名称
	private String iconCls;  //节点小图标
	private Boolean checked = false ; //是否勾选
	
	private Long pid; //父节点id
	private List<TreeNode>  children ; //子节点
	private String state = "open" ;
	
	private Map<String,Object> attributes ;//其他参数
}
