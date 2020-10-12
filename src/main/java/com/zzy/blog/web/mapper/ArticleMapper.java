package com.zzy.blog.web.mapper;

import com.zzy.blog.web.pojo.Article;
import com.zzy.blog.web.pojo.ArticleCustom;
import com.zzy.blog.web.pojo.ArticleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    long countByExample(ArticleQuery example);

    int deleteByExample(ArticleQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(@Param("record") Article record);

    int insertSelective(@Param("record") Article record);

    List<Article> selectByExampleWithBLOBs(ArticleQuery example);

    List<Article> selectByExample(ArticleQuery example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleQuery example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleQuery example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleQuery example);

    int updateByPrimaryKeySelective(@Param("record") Article record);

    int updateByPrimaryKeyWithBLOBs(@Param("record") Article record);

    int updateByPrimaryKey(@Param("record") Article record);
    
    //新增带外键内容方法
	List<ArticleCustom> selectArticleCustom(@Param("record") ArticleCustom record);
	//新增查询带外键内容方法
	ArticleCustom selectArticleCustomByPrimaryKey(Long id);
	
	int insertArticleTags(@Param("articleId") Long articleId,@Param("tagId") Long tagId);
	
	int deleteArticleTagsByArticleId(@Param("articleId") Long articleId);

	//取最新一篇正式文章的ID
	//Long getMaxId();

	long countByExTagId(@Param("tagId") Long tagId);

	List<ArticleCustom> selectArticleAllCustom(@Param("record") ArticleCustom record);
	
	
	List<ArticleCustom> selectArticleFiles();
	
	List<Article> selectArtListByYearDate(@Param("yr") String yr);
	
	long selectArtListByImageId(@Param("imageId") Long imageId);

	Article selectPrevArticleById(Long id);
	
	Article selectNextArticleById(Long id);
}