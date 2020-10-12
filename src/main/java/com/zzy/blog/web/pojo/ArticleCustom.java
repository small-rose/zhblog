package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
/*
 * 使用子类配置 相关关联
 */
@Setter
@Getter
public class ArticleCustom extends Article{

	private static final long serialVersionUID = 1L;

	private Type type;   //文章类型
	private List<Tag> tagList = new ArrayList<Tag>();  //文章标签
	private Picture image ; //封面图
	
	private List<Comment> commentList = new ArrayList<Comment>();//评论
	
	//保存时页面传值
	private Long typeId ;
	private String tagIds ;
	
	private String tagNames ;
	private String typeName;
	private Integer commentNum ;
	private String yearDate ;
	private List<Article> artList = new ArrayList<>();
	
	public String getTagNames() {
		tagNames = "";
		if(tagList.size()>0) {
			StringBuffer sb = new StringBuffer();
			for(Tag tag : tagList) {
				sb.append(tag.getTagName()).append(",");
			}
			tagNames = sb.substring(0, sb.length()-1);
			sb.setLength(0);
		}
		return tagNames;
	}

	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}

	public String getTypeName() {
		typeName = "";
		if(type!=null) {
			typeName = type.getTypeName();
		}
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getCommentNum() {
		commentNum = commentList.size();
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	} 
	
	
}
