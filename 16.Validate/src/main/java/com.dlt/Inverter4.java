package com.dlt;

/**
 * @author denglitong
 * @date 2021/1/5
 */
public class Inverter4 implements StringInverter {
	static final String ALLOWED =
			"abcdefghijklmnopqrstuvwxyz ,." +
					"ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Override
	public String invert(String str) {
		if (str.length() > 30) {
			throw new RuntimeException("argument too long!");
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (ALLOWED.indexOf(c) == -1) {
				throw new RuntimeException(c + " Not Allowed");
			}
			result.append(Character.isUpperCase(c) ? Character.toLowerCase(c) :
					Character.toUpperCase(c));
		}
		return result.toString();
	}
}
