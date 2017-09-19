package org.iskycode.jeesky.sys.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author phoenix
 *
 *         公共json工具类
 */
public class JsonUtils {
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * @param o
	 * @return
	 * 
	 * 		对象转为json字符串
	 */
	public static String toJson(Object o) {
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
