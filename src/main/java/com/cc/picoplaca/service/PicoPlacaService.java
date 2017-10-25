/**
 * 
 */
package com.cc.picoplaca.service;

/**
 * @author ccarrillo
 *
 */
public interface PicoPlacaService {
	
	Boolean isAbleToBeOnRoad (String id, String date, String time);
	
	Boolean isValidId (String id);

}
