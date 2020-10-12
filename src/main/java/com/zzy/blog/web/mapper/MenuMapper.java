package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Menu;
import com.zzy.blog.web.pojo.MenuCustom;
import com.zzy.blog.web.pojo.MenuQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuMapper {
    long countByExample(MenuQuery example);

    int deleteByExample(MenuQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuQuery example);

    Menu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuQuery example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);



	List<MenuCustom> selectMenuCustomList(MenuCustom menu);
	
	Menu selectParentById(@Param("parentId") Menu parentId);
	
	MenuCustom selectMenuCustomByPrimaryKey(Long id);
	
	List<MenuCustom>  selectShowMenuCustomList(MenuCustom menu);
	
	List<MenuCustom>  selectChildrenById(Long id);
}