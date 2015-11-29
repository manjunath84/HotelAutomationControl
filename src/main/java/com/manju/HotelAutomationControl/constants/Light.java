/**
 * 
 */
package com.manju.HotelAutomationControl.constants;

/**
 * @author Manjunathan S
 *
 */
public enum Light {
	ON(5),OFF(0);

	private int value;

	private Light(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	
}
