package com.zzy.blog.web.common.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.zzy.blog.web.pojo.SysConfig;
import com.zzy.blog.web.service.SysConfigService;

import lombok.extern.slf4j.Slf4j;

/**
 * 缓存管理工具
 * 
 * @author Administrator
 *
 */
@Slf4j
public class CacheManager {

	@Autowired
	private static SysConfigService configService;

	/** 存储缓存数据 **/
	public static Map<String, Object> sysconfig = new HashMap<String, Object>();

	/**
	 * 更新缓存数据
	 */
	public static void updateCache() {
		clearCache();
		loadData();
		log.info(sysconfig.size() + "条数据已加载到缓存!");
	}

	/**
	 * 清理缓存数据
	 */
	public static void clearCache() {
		sysconfig.clear();
	}

	/**
	 * 获取缓存数据
	 */
	public static Object getCacheData(String key) {
		return sysconfig.get(key);
	}

	/**
	 * 加载缓存数据
	 */
	private static void loadData() {
		
		List<SysConfig> list = configService.getAllList();
		for (SysConfig config : list) {
			sysconfig.put(config.getConfigCode(), config.getConfigValue());
		}
		log.info("加载缓存数据成功!");
	}

	/**
	 * 启动定时任务,经过一定的时间(单位分钟),更新缓存数据
	 * 
	 * @param minute
	 */
	public static void startTask(int minute) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				updateCache();
			}
		};
		Timer timer = new Timer();
		long delay = 0;
		long inteval = minute * 60 * 1000;
		timer.scheduleAtFixedRate(task, delay, inteval);
	}


	public static void setConfigService(SysConfigService  Service) {
		  configService =  Service;
	}
}
