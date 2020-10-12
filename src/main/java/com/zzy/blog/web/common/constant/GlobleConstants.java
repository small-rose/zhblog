package com.zzy.blog.web.common.constant;

public class GlobleConstants {
	
	public final static String SESSION_KEY = "session";
	
	public final static String SESSION_ID = "SNID" ;
	
	public final static String LOGIN_USER = "user" ;
	
	public final static Integer Best = 1;
	
	
	public final static Long userid = 1l;
	
	public final static Long infoId = 1l;
	
	public static class Show{
		/**
		 * 显示在博客首页
		 */
		public final static Integer IS_SHOW_Y = 1 ;
		/**
		 *  不显示在博客首页
		 */		
		public final static Integer IS_SHOW_N = 0 ;
	}
	
	public static class ApprFlag{
		/**
		 * 审批通过
		 */
		public final static Integer IS_APPR_FLAG_Y = 1 ;
		/**
		 *  审批驳回
		 */		
		public final static Integer IS_APPR_FLAG_N = 0 ;
		/**
		 *  等待审批
		 */		
		public final static Integer IS_APPR_FLAG_W = 2 ;
	}
	
	public static class OnOff {
		public final static String IS_ON  = "1" ;
		public final static String IS_OFF = "0" ;
	}
	
	
	public final static String CODE_KEY =  "RANDOMVALIDATECODEKEY";
}
