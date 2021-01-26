package com.xiao.blog.myblog.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	
	private static final String SALT = "tamboo";
	/**
	 * 
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	 public String encode(String password) {
	        password = password + SALT;
	        MessageDigest md5 = null;
	        try {
	            md5 = MessageDigest.getInstance("MD5");
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	        char[] charArray = password.toCharArray();
	        byte[] byteArray = new byte[charArray.length];

	        for (int i = 0; i < charArray.length; i++){
	            byteArray[i] = (byte) charArray[i];
	        }
	        byte[] md5Bytes = md5.digest(byteArray);
	        StringBuffer hexValue = new StringBuffer();
	        for (byte md5Byte : md5Bytes) {
	            int val = ((int) md5Byte) & 0xff;
	            if (val < 16) {
	                hexValue.append("0");
	            }

	            hexValue.append(Integer.toHexString(val));
	        }
	        return hexValue.toString();
	    }
}
