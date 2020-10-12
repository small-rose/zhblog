package com.zzy.blog.web.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CommentCustom extends Comment{

	private static final long serialVersionUID = 1L;

	private List<CommentCustom> children = new ArrayList<CommentCustom>();

	private Article article;
	
	private String articleTitle ;

	public String getArticleTitle() {
		
		if(article!=null) {
			articleTitle = article.getArticleTitle();
		}
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	
}
