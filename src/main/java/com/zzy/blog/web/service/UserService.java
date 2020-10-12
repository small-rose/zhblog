package com.zzy.blog.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzy.blog.web.common.exception.BussException;
import com.zzy.blog.web.mapper.UserMapper;
import com.zzy.blog.web.pojo.User;


@CacheConfig(cacheNames = "zhblogCache")
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Cacheable(key = "'user_'+#uname")
	public User getUserByName(String uname) {
		// TODO Auto-generated method stub
		return userMapper.getUserByName(uname);
	}
	
	@Cacheable(key = "'user_'+#userid")
	public User getUserInfoById(Long userid) {
		// TODO Auto-generated method stub
		System.err.println("查询用户数据信息");
		return userMapper.selectByPrimaryKey(userid);
	}

//  @CachePut: 既调用方法，又更新缓存数据；同步更新缓存
	//  修改了数据库的某个数据，同时更新缓存
	//  运行：
	//      1.先调用目标方法
	//      2.将目标方法的结果缓存起来
	@CachePut(key = "#object.id")
	public void update(User object) throws Exception{
		// TODO Auto-generated method stub
		if(object==null || object.getId()==null) {
			throw new BussException("无法更新博主信息");
		}
		User record = new User();
		record.setId(object.getId());
		record.setGitAcct(object.getGitAcct());
		record.setGitBlogUrl(object.getGitBlogUrl());
		record.setQqAcct(object.getQqAcct());
		record.setWbAcct(object.getWbAcct());
		record.setWxPrivate(object.getWxPrivate());
		record.setWxPublic(object.getWxPublic());
		record.setRealName(object.getRealName());
		record.setPersonalBrief(object.getPersonalBrief());
		record.setLocalImgUrl(object.getLocalImgUrl());
		record.setBloggerMsg(object.getBloggerMsg());
		userMapper.updateByPrimaryKeySelective(record);
	}
	
	public void updatePass(User object) throws Exception{
		userMapper.updateByPrimaryKeySelective(object);
	}
}
