/**
 * 
 */
package com.manju.HotelAutomationControl.constants;

/**
 * @author Manjunathan S
 *
 */
public enum AirConditioner {
	ON(10),OFF(0);

	private int value;

	private AirConditioner(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
