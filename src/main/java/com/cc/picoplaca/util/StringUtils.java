/**
 * 
 */
package com.cc.picoplaca.util;

/**
 * @author ccarrillo
 *
 */
public class StringUtils {
	
	private StringUtils() {}
	
	public static Integer getLastDigit (String id) {
		if(id != null && id.length() > 0) {
			return Integer.parseInt(id.substring(id.length() - 1));
		}
		
		return -1;
	}
}
