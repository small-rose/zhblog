package com.zzy.blog.web.base.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecuritUtil {

	private static final String Algorithm = "DESede";
	
	/**
	 * MD5加密
	 * 
	 * @param str 加密前字符串
	 * @return 加密后字符串
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}
		
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				
			} else {
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
				
			}
		}

		return md5StrBuff.toString();
	}
	
	/**
	 * 3des加密
	 * 
	 * @param keybyte 密钥
	 * @param src 要加密的字符串
	 * @return
	 */
	public static byte[] desEncryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 3des解密
	 * 
	 * @param keybyte 密钥
	 * @param src 要解密的字符串
	 * @return
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static byte[] desDecryptMode(byte[] keybyte, byte[] src) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// 生成密钥
		SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

		// 解密
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		return c1.doFinal(src);
	}
	
	/**
	 * base64加密
	 * 
	 * @param src 要加密的字符串
	 * @return
	 */
	public static String baseEncryptMode(String src) {
		BASE64Encoder encode = new BASE64Encoder();
		return encode.encode(src.getBytes());
	}
	
	/**
	 * base64解密
	 * 
	 * @param src 要解密的字符串
	 * @return
	 */
	public static byte[] baseDecryptMode(String src) {
		BASE64Decoder decode = new BASE64Decoder();
		try {
			return decode.decodeBuffer(src);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}