package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Link;
import com.zzy.blog.web.pojo.LinkQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LinkMapper {
    long countByExample(LinkQuery example);

    int deleteByExample(LinkQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Link record);

    int insertSelective(Link record);

    List<Link> selectByExample(LinkQuery example);

    Link selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Link record, @Param("example") LinkQuery example);

    int updateByExample(@Param("record") Link record, @Param("example") LinkQuery example);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);
}