package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.mapper.ArticleMapper;
import com.zzy.blog.web.mapper.TagMapper;
import com.zzy.blog.web.pojo.Tag;
import com.zzy.blog.web.pojo.TagQuery;
import com.zzy.blog.web.pojo.TagQuery.Criteria;
import com.zzy.blog.web.vo.CustomIds;

import lombok.extern.slf4j.Slf4j;


@CacheConfig(cacheNames = "zhblogCache")
@Slf4j
@Service
public class TagService {

	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private ArticleMapper articleMapper;
	
	public List<Tag> findAll(Tag tag, HttpServletRequest request) {
		// TODO Auto-generated method stub
		TagQuery example = new TagQuery();
		Criteria criteria = example.createCriteria();
		if(tag!=null){
			if(!StringUtils.isEmpty(tag.getTagName())){
				 criteria.andTagNameLike(tag.getTagName());
			 }
			if(tag.getIsShow()!=null &&  tag.getIsShow()>-1){
				 criteria.andIsShowEqualTo(tag.getIsShow());
			 }
		}
		example.setOrderByClause("id desc");
		List<Tag> list = tagMapper.selectByExample(example);
		return list;
	}

	public void save(Tag object) {
		// TODO Auto-generated method stub
		if(object.getId()==null) {
			//新增
			object.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
			object.setAddDate(DateUtils.getDateTime());
			tagMapper.insertSelective(object);
		}else {
			//修改
			Tag record = new Tag();
			record.setId(object.getId());
			record.setTagCode(object.getTagCode());
			record.setTagName(object.getTagName());
			record.setTagNote(object.getTagNote());
			record.setUpdateDate(DateUtils.getDateTime());
			tagMapper.updateByPrimaryKeySelective(record);
		}
	}
	@Transactional
	public void delete(CustomIds custId) throws BussException{
		// TODO Auto-generated method stub
		String msg = "";
		if(custId!=null) {
			for(Long id : custId.getIds()) {
				long x = articleMapper.countByExTagId(id);
				if(x>0) {
					Tag tmp = tagMapper.selectByPrimaryKey(id);
					throw new BussException("标签【"+tmp.getTagName()+"】已经被使用，禁止删除！");
				}
				tagMapper.deleteByPrimaryKey(id);
			}
		}
	}

	public Tag getTagById(Long id) {
		// TODO Auto-generated method stub
		return tagMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delTagByIds(Long[] ids) throws BussException{
		// TODO Auto-generated method stub
		for(Long id : ids) {
			long x = articleMapper.countByExTagId(id);
			if(x>0) {
				Tag tmp = tagMapper.selectByPrimaryKey(id);
				throw new BussException("标签【"+tmp.getTagName()+"】已经被使用，禁止删除！");
			}
			tagMapper.deleteByPrimaryKey(id);
		}
	}
	
	public void changeShow(Tag tag) {
		// TODO Auto-generated method stub
		Tag record = new Tag();
		record.setId(tag.getId());
		if(GlobleConstants.Show.IS_SHOW_Y.equals(tag.getIsShow())) {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_N);
		}else {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
		}
		tagMapper.updateByPrimaryKeySelective(record);
	}

	public List<Tag> getTagsByArticleId(Long id) {
		// TODO Auto-generated method stub
		return tagMapper.selectTagListByArtId(id);
	}
	
	
	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+'tagList'")
	public List<Tag> getAllList() {
		TagQuery example = new TagQuery();
		Criteria criteria = example.createCriteria();
		criteria.andIsShowEqualTo(GlobleConstants.Show.IS_SHOW_Y);
		List<Tag> list = tagMapper.selectByExample(example);
		return list;
	}
}
