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
public class SubCorridor extends Corridor{

	/**
	 * protected constructor to instantiate the Sub corridor based on time slot.
	 * 
	 * @param corridorNo
	 * @param timeSlot
	 */
	protected SubCorridor(int corridorNo, TimeSlot timeSlot) {
		super(corridorNo, timeSlot==TimeSlot.NIGHT?
				Equipments.newInstance(Light.OFF, AirConditioner.ON):
					Equipments.newDefaultInstance());
	}
	
	@Override
	public void movementDetected(){		
		if(equipment.getLight()== Light.OFF){
			equipment.setLight(Light.ON);
		}
		if(equipment.getAirConditioner()==AirConditioner.OFF){
			equipment.setAirConditioner(AirConditioner.ON);
		}
	}
	
	@Override
	public void noMovementDetected(){
		if(equipment.getLight()== Light.ON){
			equipment.setLight(Light.OFF);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("  Sub corridor ");
		output.append(super.toString());
		
		return output.toString();
	}	
}
