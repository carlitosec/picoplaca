/**
 * 
 */
package com.cc.picoplaca.service;

import com.cc.picoplaca.beans.PicoPlacaBean;

/**
 * @author ccarrillo
 *
 */
public interface PicoPlacaService {
	
	Boolean isAbleToBeOnRoad (PicoPlacaBean bean);
	
	Boolean isValidId (String id);

}
