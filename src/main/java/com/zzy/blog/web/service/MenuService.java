package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.mapper.MenuMapper;
import com.zzy.blog.web.pojo.Menu;
import com.zzy.blog.web.pojo.MenuCustom;
import com.zzy.blog.web.pojo.MenuQuery;


@CacheConfig(cacheNames = "zhblogCache")
@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public List<MenuCustom> findAll(MenuCustom menu, HttpServletRequest request) {
		List<MenuCustom> list = menuMapper.selectMenuCustomList(menu);
		return list;
	}

	public void save(MenuCustom object) {
		if(object.getId()==null) {
			if(object.getParentId()==null) {
				object.setParentId(0l);
			}
			//新增
			object.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
			object.setAddDate(DateUtils.getDateTime());
			menuMapper.insertSelective(object);
		}else {
			//修改
			Menu record = new Menu();
			record.setId(object.getId());
			record.setMenuCode(object.getMenuCode());
			record.setMenuName(object.getMenuName());
			record.setMenuNote(object.getMenuNote());
			record.setMenuUrl(object.getMenuUrl());
			record.setParentId(object.getParentId());
			record.setMenuLevel(object.getMenuLevel());
			record.setIsLeaf(object.getIsLeaf());
			
			record.setUpdateDate(DateUtils.getDateTime());
			menuMapper.updateByPrimaryKeySelective(record);
		}
	}

	public MenuCustom getMenuCustomById(Long id) {
		return menuMapper.selectMenuCustomByPrimaryKey(id);
	}

	public void delMenuByIds(Long[] ids) {
		for(Long id : ids) {
			//menuMapper.deleteByPrimaryKey(id);
		}
	}

	public void changeShow(Menu menu) {
		Menu record = new Menu();
		record.setId(menu.getId());
		if(GlobleConstants.Show.IS_SHOW_Y.equals(menu.getIsShow())) {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_N);
		}else {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
		}
		menuMapper.updateByPrimaryKeySelective(record);
	}

	public List<Menu> findList() {
		MenuQuery query = new MenuQuery();
		return menuMapper.selectByExample(query);
	}
	
    @Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+'menuList'")
	public List<MenuCustom> getAllList() {
		MenuCustom menu = new MenuCustom();
		menu.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
		List<MenuCustom> list = menuMapper.selectShowMenuCustomList(menu);
		return list;
	}

}
