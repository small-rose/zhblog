package com.zzy.blog.web.base.page;

import java.util.ArrayList;
import java.util.List;

import com.zzy.blog.web.pojo.MenuCustom;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TreeTableNode {

	private Long id ;
	 private Long pid  ;
	private String name ;
	
	private String menuCode;
    private String menuUrl;
    private String menuNote;
   
    private Integer isShow;
    private String addDate;
    private String updateDate;
    private Integer isLeaf;
    private Integer menuLevel;
    
	public TreeTableNode(){
		
	}
	
	public TreeTableNode(MenuCustom custom){
		this.id = custom.getId();
		this.name  = custom.getMenuName();
		this.menuCode = custom.getMenuCode();
		this.menuUrl = custom.getMenuUrl();
		this.menuNote = custom.getMenuNote();
		this.pid = custom.getParentId();
		this.isShow = custom.getIsShow();
		this.addDate = custom.getAddDate();
		this.updateDate = custom.getUpdateDate();
		this.isLeaf = custom.getIsLeaf();
		this.menuLevel = custom.getMenuLevel();
	}
	
	public static List<TreeTableNode> toListTreeTableNode(List<MenuCustom> customList){
		List<TreeTableNode> result = new ArrayList<>();
		TreeTableNode node = null;
		for(MenuCustom tmp : customList) {
			node = new TreeTableNode(tmp);
			result.add(node);
		}
		return result;
	}
}
