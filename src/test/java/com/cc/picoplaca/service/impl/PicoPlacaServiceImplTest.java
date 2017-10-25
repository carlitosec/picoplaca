/**
 * 
 */
package com.cc.picoplaca.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cc.picoplaca.service.PicoPlacaService;
import com.cc.picoplaca.service.impl.PicoPlacaServiceImpl;

/**
 * @author ccarrillo
 *
 */
public class PicoPlacaServiceImplTest {
	
	private PicoPlacaService picoPlacaService;
	
	@Before
	public void setUp() {
		picoPlacaService = new PicoPlacaServiceImpl();
	}
	
	@Test
	public void validateRightIdAnyMorningTime() {
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad("PBA3212", "24/10/2017", "09:00"));
	}
	
	@Test
	public void validateRightIdAnyEveningTime() {
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad("PBA3212", "24/10/2017", "19:00"));
	}
	
	@Test
	public void validateIdWrongMorningTimeAndDay() {
		Assert.assertFalse(picoPlacaService.isAbleToBeOnRoad("PBA3212", "23/10/2017", "08:00"));
	}
	
	@Test
	public void validateIdWrongEveningTimeAndDay() {
		Assert.assertFalse(picoPlacaService.isAbleToBeOnRoad("PBA3212", "23/10/2017", "17:00"));
	}
	
	@Test
	public void validateIdRightTimeAndWrongDay() {
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad("PBA3212", "23/10/2017", "10:00"));
	}
	
	@Test
	public void validateIdSaturday() {
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad("PBA3212", "14/10/2017", "08:00"));
	}
	
	@Test
	public void validateIdSunday() {
		Assert.assertTrue(picoPlacaService.isAbleToBeOnRoad("PBA3212", "15/10/2017", "08:00"));
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
