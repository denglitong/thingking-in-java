package com.dlt;

/**
 * @author denglitong
 * @date 2020/2/8
 */
public class Inverter2 implements StringInverter {
	@Override
	public String invert(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			result.append(Character.isUpperCase(c) ? Character.toLowerCase(c) :
					Character.toUpperCase(c));
		}
		return result.toString();
	}
}
