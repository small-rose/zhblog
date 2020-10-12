package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Tag;
import com.zzy.blog.web.pojo.TagQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagMapper {


	long countByExample(TagQuery example);

    int deleteByExample(TagQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagQuery example);

    Tag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagQuery example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagQuery example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
    
    List<Tag> selectTagListByArtId(Long id );
}