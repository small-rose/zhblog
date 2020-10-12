package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Comment;
import com.zzy.blog.web.pojo.CommentCustom;
import com.zzy.blog.web.pojo.CommentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
    long countByExample(CommentQuery example);

    int deleteByExample(CommentQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExampleWithBLOBs(CommentQuery example);

    List<Comment> selectByExample(CommentQuery example);

    Comment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

	List<CommentCustom> selectCommentCustom(Comment record);
	
	List<CommentCustom> selectchildrenById(Long id);
	
	List<CommentCustom> selectCommentListByArtId(Long id);//展示评论列表
	
	List<Comment> selectCommentListByArticleId(Long id);//统计评论数量专用
}