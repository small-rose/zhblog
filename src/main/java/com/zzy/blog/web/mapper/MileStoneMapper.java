package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.MileStone;
import com.zzy.blog.web.pojo.MileStoneQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MileStoneMapper {
    long countByExample(MileStoneQuery example);

    int deleteByExample(MileStoneQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(MileStone record);

    int insertSelective(MileStone record);

    List<MileStone> selectByExample(MileStoneQuery example);

    MileStone selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MileStone record, @Param("example") MileStoneQuery example);

    int updateByExample(@Param("record") MileStone record, @Param("example") MileStoneQuery example);

    int updateByPrimaryKeySelective(MileStone record);

    int updateByPrimaryKey(MileStone record);
}