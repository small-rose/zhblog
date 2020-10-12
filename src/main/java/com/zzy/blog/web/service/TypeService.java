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
import com.zzy.blog.web.mapper.TypeMapper;
import com.zzy.blog.web.pojo.Type;
import com.zzy.blog.web.pojo.TypeQuery;
import com.zzy.blog.web.pojo.TypeQuery.Criteria;

import lombok.extern.slf4j.Slf4j;

@CacheConfig(cacheNames = "zhblogCache")
@Slf4j
@Service
public class TypeService {

	@Autowired
	private TypeMapper typeMapper;

	public List<Type> findAll(Type type, HttpServletRequest request) {
		// TODO Auto-generated method stub
		TypeQuery example = new TypeQuery();
		Criteria criteria = example.createCriteria();
		if(type!=null){
			if(!StringUtils.isEmpty(type.getTypeName())){
				 criteria.andTypeNameLike(type.getTypeName());
			 }
			if(type.getIsShow()!=null && type.getIsShow()>-1){
				 criteria.andIsShowEqualTo(type.getIsShow());
			 }
		}
		example.setOrderByClause("id desc");
		List<Type> list = typeMapper.selectByExample(example);
		return list;
	}

	public void save(Type object) {
		// TODO Auto-generated method stub
		if(object.getId()==null) {
			//新增
			object.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
			object.setAddDate(DateUtils.getDateTime());
			typeMapper.insertSelective(object);
		}else {
			//修改
			Type record = new Type();
			record.setId(object.getId());
			record.setTypeCode(object.getTypeCode());
			record.setTypeName(object.getTypeName());
			record.setTypeNote(object.getTypeNote());
			record.setUpdateDate(DateUtils.getDateTime());
			typeMapper.updateByPrimaryKeySelective(record);
		}
	}
	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+#id")
	public Type getTypeById(Long id) {
		// TODO Auto-generated method stub
		return typeMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delTypeByIds(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id : ids) {
			long x = typeMapper.countByTypeId(id);
			if(x>0) {
				Type tmp = typeMapper.selectByPrimaryKey(id);
				throw new RuntimeException("分类【"+tmp.getTypeName()+"】已经被使用，禁止删除！");
			}
			typeMapper.deleteByPrimaryKey(id);
		}
	}
	
	public void changeShow(Type type) {
		// TODO Auto-generated method stub
		Type record = new Type();
		record.setId(type.getId());
		if(GlobleConstants.Show.IS_SHOW_Y.equals(type.getIsShow())) {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_N);
		}else {
			record.setIsShow(GlobleConstants.Show.IS_SHOW_Y);
		}
		typeMapper.updateByPrimaryKeySelective(record);
	}
	
}
