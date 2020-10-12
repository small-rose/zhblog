package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.SysLog;
import com.zzy.blog.web.pojo.SysLogQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysLogMapper {
    long countByExample(SysLogQuery example);

    int deleteByExample(SysLogQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExampleWithBLOBs(SysLogQuery example);

    List<SysLog> selectByExample(SysLogQuery example);

    SysLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogQuery example);

    int updateByExampleWithBLOBs(@Param("record") SysLog record, @Param("example") SysLogQuery example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogQuery example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);
}