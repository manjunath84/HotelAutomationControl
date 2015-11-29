/**
 * 
 */
package com.manju.HotelAutomationControl.bean;


/**
 * @author Manjunathan S
 *
 */
public abstract class Corridor {
	
	protected final int corridorNo;
	
	protected final Equipments equipment;
	
	/**
	 * @param corridorNo
	 * @param equipment
	 */
	protected Corridor(int corridorNo, Equipments equipment){
		this.corridorNo = corridorNo;
		this.equipment = equipment;
	}
	
	/**
	 * @return the corridorNo
	 */
	public int getCorridorNo() {
		return corridorNo;
	}	

	/**
	 * @return the equipment
	 */
	public Equipments getEquipment() {
		return equipment;
	}
	
	/**
	 * This abstract method will be invoked when a movement is detected 
	 * in the Corridor
	 * 
	 */
	public abstract void movementDetected();
	
	/**
	 * This abstract method will be invoked when no movement is detected 
	 * in the Corridor
	 * 
	 */
	public abstract void noMovementDetected();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(corridorNo).append("\n");
		output.append("    Light ").append(corridorNo).append(" : ").append(
				equipment.getLight()).append("\n");
		output.append("    AC : ").append(
				equipment.getAirConditioner()).append("\n");
		
		return output.toString();
	}	
}
