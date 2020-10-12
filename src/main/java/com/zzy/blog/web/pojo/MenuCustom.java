package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuCustom extends Menu{
	

	private static final long serialVersionUID = 1L;

	private Menu parent;

	private List<MenuCustom> children = new ArrayList<MenuCustom>();
	
	private Integer childCount ;

	public Integer getChildCount() {
		childCount = children.size();
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}
	
	
}
