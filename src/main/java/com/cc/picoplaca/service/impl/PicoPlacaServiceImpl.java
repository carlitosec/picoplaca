package com.cc.picoplaca.service.impl;

import java.sql.Time;

import com.cc.picoplaca.service.PicoPlacaService;
import com.cc.picoplaca.util.Constants;
import com.cc.picoplaca.util.DateUtils;
import com.cc.picoplaca.util.MapUtils;
import com.cc.picoplaca.util.StringUtils;

/**
 * 
 */

/**
 * @author ccarrillo
 *
 */
public class PicoPlacaServiceImpl implements PicoPlacaService {

	/* (non-Javadoc)
	 * @see com.stackbuilder.picoplaca.service.PicoPlacaService#isAbleToBeOnRoad(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean isAbleToBeOnRoad(String id, String date, String time) {
		
		Integer day = DateUtils.getDayOfWeekFromDate(date);
		
		if (day < 0) {
			return false;
		}
		
		Integer lastDigit = StringUtils.getLastDigit(id);
		
		Time parsedTime = DateUtils.getParsedTime(time);
		
		String[] values = MapUtils.getDigitsFromDay(day).split(",");
		
		if (values[0].equals(Constants.ALL_IDS)) {
			return true;
		}
		
		for (String digit : values) {
			if (Integer.parseInt(digit) == lastDigit 
					&& ((parsedTime.after(DateUtils.getParsedTime(Constants.TIME_MORNING_FROM)) 
							&& parsedTime.before(DateUtils.getParsedTime(Constants.TIME_MORNING_TO))
					|| (parsedTime.after(DateUtils.getParsedTime(Constants.TIME_EVENING_FROM)) 
							&& parsedTime.before(DateUtils.getParsedTime(Constants.TIME_EVENING_TO)))
					
					
					))) {
				return false;
			}
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.cc.picoplaca.service.PicoPlacaService#isValidId(java.lang.String)
	 */
	public Boolean isValidId(String id) {
		return id.matches(Constants.REG_EXP_ID); 
	}
	
	

}
