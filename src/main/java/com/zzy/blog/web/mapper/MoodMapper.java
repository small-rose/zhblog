package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.pojo.MoodQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MoodMapper {
    long countByExample(MoodQuery example);

    int deleteByExample(MoodQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Mood record);

    int insertSelective(Mood record);

    List<Mood> selectByExample(MoodQuery example);

    Mood selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mood record, @Param("example") MoodQuery example);

    int updateByExample(@Param("record") Mood record, @Param("example") MoodQuery example);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}