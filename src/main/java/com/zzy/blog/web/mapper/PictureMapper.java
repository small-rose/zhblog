package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Picture;
import com.zzy.blog.web.pojo.PictureQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PictureMapper {
    long countByExample(PictureQuery example);

    int deleteByExample(PictureQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExampleWithBLOBs(PictureQuery example);

    List<Picture> selectByExample(PictureQuery example);

    Picture selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureQuery example);

    int updateByExampleWithBLOBs(@Param("record") Picture record, @Param("example") PictureQuery example);

    int updateByExample(@Param("record") Picture record, @Param("example") PictureQuery example);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKeyWithBLOBs(Picture record);

    int updateByPrimaryKey(Picture record);
    
    List<Picture> selecListByCateId(@Param("cateId")  Long cateId);
    
    int selectByCateId(@Param("cateId")  Long cateId);


}