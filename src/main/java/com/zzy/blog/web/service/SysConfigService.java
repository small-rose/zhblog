package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.mapper.ArticleMapper;
import com.zzy.blog.web.mapper.SysConfigMapper;
import com.zzy.blog.web.pojo.SysConfig;
import com.zzy.blog.web.pojo.SysConfigQuery;
import com.zzy.blog.web.pojo.SysConfigQuery.Criteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SysConfigService {

	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private ArticleMapper articleMapper;
	
	public List<SysConfig> findAll(SysConfig sysConfig, HttpServletRequest request) {
		// TODO Auto-generated method stub
		SysConfigQuery example = new SysConfigQuery();
		Criteria criteria = example.createCriteria();
		if(sysConfig!=null){
			if(!StringUtils.isEmpty(sysConfig.getConfigModule())){
				 criteria.andConfigModuleLikeAnyWhere(sysConfig.getConfigModule());
			 }
			if(!StringUtils.isEmpty(sysConfig.getConfigName())){
				 criteria.andConfigNameLikeAnyWhere(sysConfig.getConfigName());
			 }
		}
		example.setOrderByClause("id desc");
		List<SysConfig> list = sysConfigMapper.selectByExample(example);
		return list;
	}

	public void save(SysConfig object) {
		// TODO Auto-generated method stub
		if(object.getId()==null) {
			//新增
			object.setAddDate(DateUtils.getDateTime());
			sysConfigMapper.insertSelective(object);
		}else {
			//修改
			SysConfig record = new SysConfig();
			record.setId(object.getId());
			record.setConfigModule(object.getConfigModule());
			record.setConfigName(object.getConfigName());
			record.setConfigValue(object.getConfigValue());
			record.setUpdDate(DateUtils.getDateTime());
			sysConfigMapper.updateByPrimaryKeySelective(record);
		}
	}
	

	public SysConfig getSysConfigById(Long id) {
		// TODO Auto-generated method stub
		return sysConfigMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delSysConfigByIds(Long[] ids) throws BussException{
		// TODO Auto-generated method stub
		for(Long id : ids) {
			sysConfigMapper.deleteByPrimaryKey(id);
		}
	}
	
	

	public List<SysConfig> getAllList() {
		SysConfigQuery example = new SysConfigQuery();
		List<SysConfig> list = sysConfigMapper.selectByExample(example);
		return list;
	}


	public void loadCacheData() {
		CacheManager.updateCache();
	}

}
