package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.pojo.TypeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TypeMapper {

	long countByExample(TypeQuery example);

    int deleteByExample(TypeQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeQuery example);

    Type selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeQuery example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeQuery example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

	long countByTypeId(Long id);
}