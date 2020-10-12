package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.mapper.SysExceptionMapper;
import com.zzy.blog.web.mapper.SysLogMapper;
import com.zzy.blog.web.pojo.SysException;
import com.zzy.blog.web.pojo.SysExceptionQuery;
import com.zzy.blog.web.pojo.SysLog;
import com.zzy.blog.web.pojo.SysLogQuery;
import com.zzy.blog.web.pojo.SysLogQuery.Criteria;

@Service
public class LogExceptionService {

	@Autowired
	private SysLogMapper logMapper;
	
	@Autowired
	private SysExceptionMapper exceptionMapper;

	public List<SysLog> findAllSysLog(SysLog syslog, HttpServletRequest request) {
		SysLogQuery example = new SysLogQuery();
		Criteria crt = example.createCriteria();
		example.setOrderByClause(" id desc");
		List<SysLog> logList = logMapper.selectByExample(example);
		return logList;
	}

	public List<SysException> findAllSysException(SysException exception, HttpServletRequest request) {
		SysExceptionQuery example = new SysExceptionQuery();
		example.setOrderByClause(" id desc");
		List<SysException> logList = exceptionMapper.selectByExample(example );
		return logList;
	}
	
	
}
