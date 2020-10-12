package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.mapper.CommentMapper;
import com.zzy.blog.web.pojo.Comment;
import com.zzy.blog.web.pojo.CommentCustom;
import com.zzy.blog.web.pojo.CommentQuery;
import com.zzy.blog.web.pojo.CommentQuery.Criteria;
import com.zzy.blog.web.vo.LikeJson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {

	@Autowired
	private CommentMapper commentMapper;

	public List<CommentCustom> findAll(Comment comment, HttpServletRequest request) {
		
		List<CommentCustom> list = commentMapper.selectCommentCustom(comment);
		return list;
	}

	public Comment save(CommentCustom object) {

		// 新增
		String newContent = StringEscapeUtils.unescapeHtml4(object.getCmtContent());

		Comment comment = new Comment();
		comment.setCmtDate(DateUtils.getDateTime());
		comment.setArticleId(object.getArticleId());
		comment.setCmtContent(newContent);
		comment.setCmtUtx(object.getCmtUtx());
		comment.setCmtUname(object.getCmtUname());
		comment.setCmtUemail(object.getCmtUemail());
		comment.setCmtWebUrl(object.getCmtWebUrl());
		
		Long pid = object.getParentId() == null ? 0 : object.getParentId();
		comment.setParentId(pid);
		
		String cmtOnOff = (String) CacheManager.getCacheData(ConfigKey.COMMENT_APPR_ON_OFF);
		if(GlobleConstants.OnOff.IS_ON.equals( cmtOnOff)) {
			comment.setCmtAppr(GlobleConstants.ApprFlag.IS_APPR_FLAG_W);
		}else {
			comment.setCmtAppr(GlobleConstants.ApprFlag.IS_APPR_FLAG_Y);
		}
		commentMapper.insertSelective(comment);

		return commentMapper.selectByPrimaryKey(comment.getId());
	}
	
	public Comment getCommentById(Long id) {
		return commentMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delCommentByIds(Long[] ids) {
		for(Long id : ids) {
			commentMapper.deleteByPrimaryKey(id);
		}
	}

	public List<CommentCustom> getAllList() {
		Comment comment = new Comment();
		List<CommentCustom> list = commentMapper.selectCommentCustom(comment);
		return list;
	}

	public Comment addLike(Long id) {
		// TODO Auto-generated method stub
		Comment comment = getCommentById(id);
		Integer likes = comment.getLikeYes(); 
		Comment record = new Comment();
		record.setId(comment.getId());
		record.setLikeYes(likes+1);
		commentMapper.updateByPrimaryKeySelective(record);
		Comment lastComment = getCommentById(id);
		return lastComment;
	}

	public long countAllCommentByArtId(Long aId) {
		CommentQuery example = new CommentQuery();
		Criteria crt = example.createCriteria();
		crt.andCmtApprEqualTo(GlobleConstants.ApprFlag.IS_APPR_FLAG_Y);
		crt.andArticleIdEqualTo(aId) ;
		return commentMapper.countByExample(example);
	}

	public Comment addCommentLike(LikeJson likeJson) {
		Comment comment = getCommentById(likeJson.getId());
		
		Comment record = new Comment();
		record.setId(comment.getId());
		if(likeJson.getIsLike() > 0) {
			Integer likes = comment.getLikeYes(); 
			record.setLikeYes(likes+1);
		}else {
			Integer likes = comment.getLikeNo(); 
			record.setLikeNo(likes+1);
		}
		
		commentMapper.updateByPrimaryKeySelective(record);
		Comment lastComment = getCommentById(record.getId());
		return lastComment;
		
	}

	
	
	
}
