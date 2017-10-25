/**
 * 
 */
package com.cc.picoplaca.beans;

/**
 * @author ccarrillo
 *
 */
public class PicoPlacaBean {
	
	private String carId;
	private String date;
	private String time;
	
	public PicoPlacaBean() {}
	
	public PicoPlacaBean(String carId, String date, String time) {
		this.carId = carId;
		this.date = date;
		this.time = time;
	}
	
	/**
	 * @return the carId
	 */
	public String getCarId() {
		return carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
}
