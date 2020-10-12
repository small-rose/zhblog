package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.SysException;
import com.zzy.blog.web.pojo.SysExceptionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysExceptionMapper {
    long countByExample(SysExceptionQuery example);

    int deleteByExample(SysExceptionQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SysException record);

    int insertSelective(SysException record);

    List<SysException> selectByExampleWithBLOBs(SysExceptionQuery example);

    List<SysException> selectByExample(SysExceptionQuery example);

    SysException selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysException record, @Param("example") SysExceptionQuery example);

    int updateByExampleWithBLOBs(@Param("record") SysException record, @Param("example") SysExceptionQuery example);

    int updateByExample(@Param("record") SysException record, @Param("example") SysExceptionQuery example);

    int updateByPrimaryKeySelective(SysException record);

    int updateByPrimaryKeyWithBLOBs(SysException record);

    int updateByPrimaryKey(SysException record);
}