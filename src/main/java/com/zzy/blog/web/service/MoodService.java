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
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.mapper.MoodMapper;
import com.zzy.blog.web.pojo.Mood;
import com.zzy.blog.web.pojo.MoodQuery;
import com.zzy.blog.web.pojo.MoodQuery.Criteria;

import lombok.extern.slf4j.Slf4j;

@CacheConfig(cacheNames = "zhblogCache")
@Slf4j
@Service
public class MoodService {

	@Autowired
	private MoodMapper moodMapper;

	public List<Mood> findAll(Mood mood, HttpServletRequest request) {
		// TODO Auto-generated method stub
		MoodQuery example = new MoodQuery();
		Criteria criteria = example.createCriteria();
		if(mood!=null){
			if(!StringUtils.isEmpty(mood.getMoodTitle())){
				 criteria.andMoodTitleLike(mood.getMoodTitle());
			 }
			if(!StringUtils.isEmpty(mood.getMoodContent())){
				 criteria.andMoodContentLike(mood.getMoodContent());
			 }
		}
		example.setOrderByClause("id desc");
		List<Mood> list = moodMapper.selectByExample(example);
		return list;
	}

	public void save(Mood object) {
		// TODO Auto-generated method stub
		if(object.getId()==null) {
			//新增
			object.setMoodDate(DateUtils.getDateTime());
			String newContent = StringEscapeUtils.unescapeHtml4(object.getMoodContent());
			object.setMoodContent(newContent);
			moodMapper.insertSelective(object);
		}else {
			//修改
			Mood record = new Mood();
			record.setId(object.getId());
			record.setMoodTitle(object.getMoodTitle());
			String newContent = StringEscapeUtils.unescapeHtml4(object.getMoodContent());
			record.setMoodContent(newContent);
			
			moodMapper.updateByPrimaryKeySelective(record);
		}
	}
	
	public Mood getMoodById(Long id) {
		// TODO Auto-generated method stub
		return moodMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delMoodByIds(Long[] ids) {
		// TODO Auto-generated method stub
		for(Long id : ids) {
			moodMapper.deleteByPrimaryKey(id);
		}
	}
	@Cacheable(key = "#root.targetClass.simpleName+':'+#root.methodName+':'+'moodList'")
	public List<Mood> getAllList() {
		// TODO Auto-generated method stub
		MoodQuery example = new MoodQuery();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("id desc");
		List<Mood> list = moodMapper.selectByExample(example);
		return list;
	}

	public Mood addLike(Long id) {
		// TODO Auto-generated method stub
		Mood mood = getMoodById(id);
		Integer likes = mood.getMoodLike(); 
		Mood record = new Mood();
		record.setId(mood.getId());
		record.setMoodLike(likes+1);
		moodMapper.updateByPrimaryKeySelective(record);
		Mood lastMood = getMoodById(id);
		return lastMood;
	}
	
	
	
}
