package com.zzy.blog.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzy.blog.web.base.utils.CookieUtil;
import com.zzy.blog.web.base.utils.DateUtils;
import com.zzy.blog.web.base.utils.SessionManager;
import com.zzy.blog.web.base.utils.StringUtils;
import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.common.constant.ConfigKey;
import com.zzy.blog.web.common.constant.GlobleConstants;
import com.zzy.blog.web.mapper.MessageMapper;
import com.zzy.blog.web.pojo.Message;
import com.zzy.blog.web.pojo.MessageCustom;
import com.zzy.blog.web.pojo.MessageQuery;
import com.zzy.blog.web.pojo.MessageQuery.Criteria;
import com.zzy.blog.web.pojo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageService {

	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private UserService userService;
	public List<Message> findAll(Message message, HttpServletRequest request) {
		// TODO Auto-generated method stub
		MessageQuery example = new MessageQuery();
		Criteria criteria = example.createCriteria();
		if(message!=null){
			if(!StringUtils.isEmpty(message.getMsgUname())){
				 criteria.andMsgUnameLike(message.getMsgUname());
			 }
			if(!StringUtils.isEmpty(message.getMsgUemail())){
				 criteria.andMsgUemailLike(message.getMsgUemail());
			 }
			if(!StringUtils.isEmpty(message.getParentId())){
				 criteria.andParentIdEqualTo(message.getParentId());
			 }
		}
		example.setOrderByClause("id desc");
		List<Message> list = messageMapper.selectByExample(example);
		return list;
	}

	public MessageCustom save(Message object) {
		 //新增
		object.setMsgTime(DateUtils.getDateTime());
		String newContent = StringEscapeUtils.unescapeHtml4(object.getMsgContent());
		object.setMsgContent(newContent);
		
		String sayOnff = (String) CacheManager.getCacheData(ConfigKey.SAY_APPR_ON_OFF);
        if(GlobleConstants.OnOff.IS_ON.equals(sayOnff)) {//留言审核开关开启时需要审核
        	object.setMsgAppr(GlobleConstants.ApprFlag.IS_APPR_FLAG_W);
		}else {
        	object.setMsgAppr(GlobleConstants.ApprFlag.IS_APPR_FLAG_Y);
		}
        
		messageMapper.insertSelective(object);
		 
		MessageCustom msg = messageMapper.selectMessageCustomByPrimaryKey(object.getId());
		return msg;
	}
	
	public Message getMessageById(Long id) {
		// TODO Auto-generated method stub
		return messageMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public void delMessageByIds(Long[] ids) {
		for(Long id : ids) {
			messageMapper.deleteByPrimaryKey(id);
		}
	}

	public List<MessageCustom> getAllList() {
		String saySize = (String) CacheManager.getCacheData(ConfigKey.SHOW_SAY_SIZE);
		
		List<MessageCustom> list = messageMapper.selectMessageCustomList();
		return list;
	}

	public long countAllSay() {
		MessageQuery example = new MessageQuery();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdIsNullOrZero();

		long count = messageMapper.countByExample(example);
		return count;
	}

	@Transactional
	public void returnMessage(Message object, HttpServletRequest request) {
		String sessionId = CookieUtil.getValueByKey(request, GlobleConstants.SESSION_ID);
		HttpSession session = SessionManager.getSession(sessionId);
		User user = (User) session .getAttribute(GlobleConstants.LOGIN_USER);
		User buser = userService.getUserByName(user.getUserName());
		
		object.setMsgTime(DateUtils.getDateTime());
		String newContent = StringEscapeUtils.unescapeHtml4(object.getMsgContent());
		object.setMsgContent(newContent);
		object.setMsgUemail(buser.getEmail());
		object.setMsgUname(buser.getRealName());
		object.setMsgUtx(buser.getLocalImgUrl());
		messageMapper.insertSelective(object);
	}

	
	
	
	
}
