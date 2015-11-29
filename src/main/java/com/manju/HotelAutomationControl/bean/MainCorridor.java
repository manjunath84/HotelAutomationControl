/**
 * 
 */
package com.manju.HotelAutomationControl.bean;

import com.manju.HotelAutomationControl.constants.AirConditioner;
import com.manju.HotelAutomationControl.constants.Light;
import com.manju.HotelAutomationControl.constants.TimeSlot;

/**
 * @author Manjunathan S
 *
 */
public class MainCorridor extends Corridor{

	/**
	 * protected constructor to instantiate the Sub corridor based on time slot.
	 * 
	 * @param corridorNo
	 * @param timeSlot
	 */
	protected MainCorridor(int corridorNo, TimeSlot timeSlot) {
		super(corridorNo, timeSlot==TimeSlot.NIGHT?
				Equipments.newInstance(Light.ON, AirConditioner.ON):
					Equipments.newDefaultInstance());
	}
	
	@Override
	public void movementDetected() {
		//No action required.
	}

	@Override
	public void noMovementDetected() {
		//No action required.
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("  Main corridor ");
		output.append(super.toString());
		
		return output.toString();
	}

	
}
