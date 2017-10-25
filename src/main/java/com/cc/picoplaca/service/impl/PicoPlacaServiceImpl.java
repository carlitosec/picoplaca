package com.cc.picoplaca.service.impl;

import java.sql.Time;

import com.cc.picoplaca.beans.PicoPlacaBean;
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

	public Boolean isAbleToBeOnRoad(PicoPlacaBean bean) {
		
		Integer day = DateUtils.getDayOfWeekFromDate(bean.getDate());
		
		if (day < 0) {
			return false;
		}
		
		Integer lastDigit = StringUtils.getLastDigit(bean.getCarId());
		
		Time parsedTime = DateUtils.getParsedTime(bean.getTime());
		
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

	public Boolean isValidId(String id) {
		return id.matches(Constants.REG_EXP_ID); 
	}
	
	

}
