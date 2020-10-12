package com.zzy.blog.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.zzy.blog.web.common.cache.CacheManager;
import com.zzy.blog.web.service.SysConfigService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InitListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private SysConfigService confgService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		System.out.println(" -----onApplicationEvent------");
		if (confgService != null) {
			CacheManager.setConfigService(confgService);
		}
		try {
			confgService.loadCacheData();
		} catch (Exception e) {
			log.error("confgService load exception, {}", e);
		}
	}
}
