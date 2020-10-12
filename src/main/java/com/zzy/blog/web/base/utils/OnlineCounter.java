package com.zzy.blog.web.base.utils;

public class OnlineCounter {
	
	private static long online = 1;

	public static long getOnline() {
		return online;
	}

	public static void raise() {
		online++;
	}

	public static void reduce() {
		if(online==0) {
			return ;
		}
		online--;
	}
}
