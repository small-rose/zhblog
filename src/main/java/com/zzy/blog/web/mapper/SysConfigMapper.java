package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.SysConfig;
import com.zzy.blog.web.pojo.SysConfigQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysConfigMapper {
    long countByExample(SysConfigQuery example);

    int deleteByExample(SysConfigQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    List<SysConfig> selectByExample(SysConfigQuery example);

    SysConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigQuery example);

    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigQuery example);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

	SysConfig selectConfigByCode(@Param("code") String code);
}