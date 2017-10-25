/**
 * 
 */
package com.cc.picoplaca.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cc.picoplaca.beans.PicoPlacaBean;
import com.cc.picoplaca.service.PicoPlacaService;
import com.cc.picoplaca.service.impl.PicoPlacaServiceImpl;

/**
 * @author ccarrillo
 *
 */
public class PicoPlacaServiceImplTest {
	
	private PicoPlacaService picoPlacaService;
	private PicoPlacaBean bean;
	
	@Before
	public void setUp() {
		picoPlacaService = new PicoPlacaServiceImpl();
	}
	
	@Test
	public void validateRightIdAnyMorningTime() {
		bean = new PicoPlacaBean("PBA3212", "24/10/2017", "09:00");
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateRightIdAnyEveningTime() {
		bean = new PicoPlacaBean("PBA3212", "24/10/2017", "19:00");
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateIdWrongMorningTimeAndDay() {
		bean = new PicoPlacaBean("PBA3212", "23/10/2017", "08:00");
		Assert.assertFalse(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateIdWrongEveningTimeAndDay() {
		bean = new PicoPlacaBean("PBA3212", "23/10/2017", "17:00");
		Assert.assertFalse(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateIdRightTimeAndWrongDay() {
		bean = new PicoPlacaBean("PBA3212", "23/10/2017", "10:00");
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateIdSaturday() {
		bean = new PicoPlacaBean("PBA3212", "14/10/2017", "08:00");
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateIdSunday() {
		bean = new PicoPlacaBean("PBA3212", "15/10/2017", "08:00");
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad(bean));
	}
	
	@Test
	public void validateRightId() {
		Assert.assertTrue(picoPlacaService.isValidId("PBA3212"));
		Assert.assertTrue(picoPlacaService.isValidId("PBA321"));
	}

	@Test
	public void validateWrongId() {
		Assert.assertFalse(picoPlacaService.isValidId("PB212"));
		Assert.assertFalse(picoPlacaService.isValidId("PB2122"));
	}
}
