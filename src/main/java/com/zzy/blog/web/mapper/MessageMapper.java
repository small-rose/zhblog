package com.zzy.blog.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zzy.blog.web.pojo.Message;
import com.zzy.blog.web.pojo.MessageCustom;
import com.zzy.blog.web.pojo.MessageQuery;

@Mapper
public interface MessageMapper {
    long countByExample(MessageQuery example);

    int deleteByExample(MessageQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageQuery example);

    Message selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageQuery example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageQuery example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<MessageCustom> selectMessageCustomList();
    
    List<MessageCustom> selectChildrenById(Long id);

	MessageCustom selectMessageCustomByPrimaryKey(Long id);
}