package com.zzy.blog.web.base.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringEscapeUtils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	public static String lowerFirst(String str) {
		if (isBlank(str)) {
			return "";
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String upperFirst(String str) {
		if (isBlank(str)) {
			return "";
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			char[] arrayOfChar;
			int j = (arrayOfChar = replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()).length;
			for (int i = 0; i < j; i++) {
				char c = arrayOfChar[i];
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String rabbr(String str, int length) {
		return abbr(replaceHtml(str), length);
	}

	public static Double toDouble(Object val) {
		if (val == null) {
			return Double.valueOf(0.0D);
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
		}
		return Double.valueOf(0.0D);
	}

	public static Float toFloat(Object val) {
		return Float.valueOf(toDouble(val).floatValue());
	}

	public static Long toLong(Object val) {
		return Long.valueOf(toDouble(val).longValue());
	}

	public static Integer toInteger(Object val) {
		return Integer.valueOf(toLong(val).intValue());
	}

	public static final String MD5(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();

			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];

				str[(k++)] = hexDigits[(b >> 4 & 0xF)];
				str[(k++)] = hexDigits[(b & 0xF)];
			}
			return new String(str);
		} catch (Exception e) {
		}
		return "";
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();

		return uuid.replaceAll("-", "");
	}
	
	public static boolean isContainChinese(String str) {
		 
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}