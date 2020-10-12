package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.SysInfo;
import com.zzy.blog.web.pojo.SysInfoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysInfoMapper {
    long countByExample(SysInfoQuery example);

    int deleteByExample(SysInfoQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(SysInfo record);

    int insertSelective(SysInfo record);

    List<SysInfo> selectByExampleWithBLOBs(SysInfoQuery example);

    List<SysInfo> selectByExample(SysInfoQuery example);

    SysInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysInfo record, @Param("example") SysInfoQuery example);

    int updateByExampleWithBLOBs(@Param("record") SysInfo record, @Param("example") SysInfoQuery example);

    int updateByExample(@Param("record") SysInfo record, @Param("example") SysInfoQuery example);

    int updateByPrimaryKeySelective(SysInfo record);

    int updateByPrimaryKeyWithBLOBs(SysInfo record);

    int updateByPrimaryKey(SysInfo record);
}