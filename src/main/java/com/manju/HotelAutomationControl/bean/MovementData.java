/**
 * 
 */
package com.manju.HotelAutomationControl.bean;

/**
 * @author Manjunathan S
 *
 */
public class MovementData {

	private int floorNo;
	
	private int subCorridorNo;
	
	private boolean isMovementDetected;

	/**
	 * @return the floorNo
	 */
	public int getFloorNo() {
		return floorNo;
	}

	/**
	 * @param floorNo the floorNo to set
	 */
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	/**
	 * @return the subCorridorNo
	 */
	public int getSubCorridorNo() {
		return subCorridorNo;
	}

	/**
	 * @param subCorridorNo the subCorridorNo to set
	 */
	public void setSubCorridorNo(int subCorridorNo) {
		this.subCorridorNo = subCorridorNo;
	}

	/**
	 * @return the isMovementDetected
	 */
	public boolean isMovementDetected() {
		return isMovementDetected;
	}

	/**
	 * @param isMovementDetected the isMovementDetected to set
	 */
	public void setMovementDetected(boolean isMovementDetected) {
		this.isMovementDetected = isMovementDetected;
	}	
}
