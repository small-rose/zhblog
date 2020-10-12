package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.mapper.LinkMapper;
import com.zzy.blog.web.pojo.Link;
import com.zzy.blog.web.pojo.LinkQuery;
import com.zzy.blog.web.pojo.LinkQuery.Criteria;

import lombok.extern.slf4j.Slf4j;


@CacheConfig(cacheNames = "zhblogCache")
@Slf4j
@Service
public class LinkService {

	@Autowired
	private LinkMapper linkMapper;

	public List<Link> findAll(Link Link, HttpServletRequest request) {
		// TODO Auto-generated method stub
		LinkQuery example = new LinkQuery();
		Criteria criteria = example.createCriteria();
		if(Link!=null){
			if( Link.getApprFlag()!=null ){
				 criteria.andApprFlagEqualTo(Link.getApprFlag());
			 }
		}
		example.setOrderByClause("id desc");
		List<Link> list = linkMapper.selectByExample(example);
		return list;
	}

	public void save(Link object) {

		if(object.getId()==null) {
			//新增
			object.setApprFlag(GlobleConstants.ApprFlag.IS_APPR_FLAG_W);
			object.setAddDate(DateUtils.getDateTime());
			linkMapper.insertSelective(object);
		}
	}
	
	public Link getLinkById(Long id) {
		return linkMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delLinkByIds(Long[] ids) {
		for(Long id : ids) {
			linkMapper.deleteByPrimaryKey(id);
		}
	}
	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+'linkList'")
	public List<Link> getAllList() {
		LinkQuery example = new LinkQuery();
		Criteria criteria = example.createCriteria();
		criteria.andApprFlagEqualTo(GlobleConstants.ApprFlag.IS_APPR_FLAG_Y);
		
		List<Link> list = linkMapper.selectByExample(example);
		return list;
	}

	public void apprHandle(Link object) {
		Link record = new Link();
		record.setId(object.getId());
		record.setApprFlag(object.getApprFlag());
		linkMapper.updateByPrimaryKeySelective(record);
	}

	
}
