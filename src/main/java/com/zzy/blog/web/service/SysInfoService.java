package com.zzy.blog.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.mapper.SysInfoMapper;
import com.zzy.blog.web.pojo.SysInfo;


@CacheConfig(cacheNames = "zhblogCache")
@Service
public class SysInfoService {

	@Autowired
	private SysInfoMapper sysInfoMapper;

	
	@Cacheable(key = "'sysInfo__'+#infoId")
	public SysInfo getSysInfoById(Long infoId) {
		// TODO Auto-generated method stub
		return sysInfoMapper.selectByPrimaryKey(infoId);
	}
	
	
	//  @CachePut: 既调用方法，又更新缓存数据；同步更新缓存
	//  修改了数据库的某个数据，同时更新缓存
	//  运行：
	//      1.先调用目标方法
	//      2.将目标方法的结果缓存起来
	@CachePut(key = "'sysinfochange__'+#object.id")
	public void update(SysInfo object) throws BussException {
		// TODO Auto-generated method stub
		if(object==null || object.getId()==null) {
			throw new BussException("无法更新博客信息");
		}
		SysInfo record = new SysInfo();
		record.setBlogTitle(object.getBlogTitle());
		record.setBlogStie(object.getBlogStie());
		record.setBlogBrief(object.getBlogBrief());
		record.setBlogNote(object.getBlogNote());
		record.setBlogNotice(object.getBlogNotice());
		record.setId(object.getId());
		sysInfoMapper.updateByPrimaryKeySelective(record );
	}
}
