package com.zzy.blog.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.mapper.SysLogMapper;
import com.zzy.blog.web.pojo.SysLog;

@Service
public class SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;

	public void save(SysLog log) {
		sysLogMapper.insertSelective(log);
	}
	
	
}
