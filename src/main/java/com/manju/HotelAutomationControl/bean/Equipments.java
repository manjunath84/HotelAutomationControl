/**
 * 
 */
package com.manju.HotelAutomationControl.bean;

import com.manju.HotelAutomationControl.constants.AirConditioner;
import com.manju.HotelAutomationControl.constants.Light;

/**
 * @author Manjunathan S
 *
 */
public interface Equipments {

	
	public void movementDetected();
	
	
	/**
	 * @return optimized power
	 */
	public int switchOffEquipments(){
		int optimizedPower = 0;
		if(airConditioner==AirConditioner.ON){
			airConditioner = AirConditioner.OFF;
			optimizedPower = AirConditioner.ON.getValue();
		}
		return optimizedPower;
	}
	
	/**
	 * @param maxPowerToBeConsumed
	 * @return power consumed
	 */
	public int switchOnEquipments(int maxPowerToBeConsumed){
		int powerConsumed = 0;
		if(airConditioner==AirConditioner.OFF && AirConditioner.ON.getValue()<=maxPowerToBeConsumed){
			airConditioner = AirConditioner.ON;
			powerConsumed += airConditioner.getValue();
		}
		return powerConsumed;
	}
}
