package com.zzy.blog.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.mapper.SysExceptionMapper;
import com.zzy.blog.web.mapper.SysInfoMapper;
import com.zzy.blog.web.pojo.SysException;

@Service
public class SysExceptionService {

	@Autowired
	private SysExceptionMapper exceptionMapper;

	public void save(SysException exception) {
		exceptionMapper.insertSelective(exception);
	}
	
	
}
