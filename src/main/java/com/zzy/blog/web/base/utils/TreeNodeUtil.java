package com.zzy.blog.web.base.utils;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzy.blog.web.base.page.TreeNode;


public class TreeNodeUtil {

	public static List<TreeNode> tree(List<TreeNode> nodes, Long id) {
		// 递归转化为树形
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		for (TreeNode treeNode : nodes) {
			TreeNode node = new TreeNode();
			node.setId(treeNode.getId());
			node.setText(treeNode.getText());
			node.setAttributes(treeNode.getAttributes());
			node.setIconCls(treeNode.getIconCls());
			node.setState(treeNode.getState());
			node.setPid(treeNode.getPid());
			if (id == treeNode.getPid()) {
				node.setChildren(tree(nodes, node.getId()));
				treeNodes.add(node);
			}

		}
		return treeNodes;
	}

	// 转化为TreeNode节点
	/*public static TreeNode toNode(SysMenu menu) {
		TreeNode node = new TreeNode();
		node.setId(menu.getId());
		node.setIconCls("");
		node.setPid(menu.getParentMenuId());
		node.setText(menu.getMenuName());
		Map<String, Object> attributes = new HashMap<String, Object>();
		//attributes.put("url", menu.getMenuUrl());
		node.setAttributes(attributes);
		return node;
	}*/

/*	public static List<TreeNode> toListNode(List<SysMenu> menus) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (SysMenu menu : menus) {
			nodes.add(toNode(menu));
		}
		return nodes;
	}*/

	/**
	 * 让树选中
	 * @param allMenus
	 * @param list
	 * @return
	 */
	public static List<TreeNode> TreeChecked(List<TreeNode> allMenus/*, List<SysMenu> list*/) {
		// TODO Auto-generated method stub
		for(TreeNode  treeNode : allMenus) {
			/*for(SysMenu sysMenu : list) {
				if(sysMenu.getId() == treeNode.getId()) {
					treeNode.setChecked(true);
				}
			}*/
		}
		return allMenus;
	}
}
