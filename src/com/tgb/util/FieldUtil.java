package com.tgb.util;

/**
 * <p>
 * Description:字段转换工具类
 * </p>
 * 
 * @author Administrator
 * @date 2017年5月27日 上午10:51:34
 */
public class FieldUtil {
	public static String transFiledName(String fieldName) {
		StringBuilder sb = new StringBuilder();
		if (fieldName.indexOf("_") != -1) {
			String[] name = fieldName.split("_");
			for (int i = 0; i < name.length; i++) {
				if (i == 0) {
					sb.append(name[i]);
				} else {
					sb.append(toUpperCase4Index(name[i]));
				}
			}
		} else {
			sb.append(fieldName);
		}
		return sb.toString();
	}

	// 首字母大写
	public static String captureName(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}

	public static String toUpperCase4Index(String string) {
		char[] methodName = string.toCharArray();
		methodName[0] = toUpperCase(methodName[0]);
		return String.valueOf(methodName);
	}

	/**
	 * 字符转成大写
	 * 
	 * @param chars
	 * @return
	 */
	public static char toUpperCase(char chars) {
		if (97 <= chars && chars <= 122) {
			chars ^= 32;
		}
		return chars;
	}

}
