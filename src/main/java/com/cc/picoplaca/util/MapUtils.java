/**
 * 
 */
package com.cc.picoplaca.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ccarrillo
 *
 */
public class MapUtils {
	
	private MapUtils() {}
	
	public static Map<Integer, String> getMapValues() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "ALL");
		map.put(2, "1,2");
		map.put(3, "3,4");
		map.put(4, "5,6");
		map.put(5, "7,8");
		map.put(6, "9,0");
		map.put(7, "ALL");
		
		return map;
	}
	
	public static String getDigitsFromDay (Integer day) {
		return getMapValues().get(day);
	}
}
