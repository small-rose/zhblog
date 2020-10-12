package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.PicCategorie;
import com.zzy.blog.web.pojo.PicCategorieQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PicCategorieMapper {
    long countByExample(PicCategorieQuery example);

    int deleteByExample(PicCategorieQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(PicCategorie record);

    int insertSelective(PicCategorie record);

    List<PicCategorie> selectByExample(PicCategorieQuery example);

    PicCategorie selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PicCategorie record, @Param("example") PicCategorieQuery example);

    int updateByExample(@Param("record") PicCategorie record, @Param("example") PicCategorieQuery example);

    int updateByPrimaryKeySelective(PicCategorie record);

    int updateByPrimaryKey(PicCategorie record);

	List<PicCategorie> selectPicCategorieList(@Param("record") PicCategorie record);

}