/**
 * 
 */
package com.manju.HotelAutomationControl.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.manju.HotelAutomationControl.constants.TimeSlot;


/**
 * @author Manjunathan S
 *
 */
public class Floor {

	private final int floorNo;

	private final List<Corridor> mainCorridors;

	private final List<Corridor> subCorridors;

	private int totalPowerConsumed;
	
	private TimeSlot timeSlot;

	public static class Builder{

		private final int floorNo;

		private final int noOfMainCorridors;
		
		private final int noOfSubCorridors;
		
		private TimeSlot timeSlot = TimeSlot.NIGHT;

		public Builder(int floorNo, int noOfMainCorridors, int noOfSubCorridors){
			this.floorNo = floorNo;
			this.noOfMainCorridors = noOfMainCorridors;
			this.noOfSubCorridors = noOfSubCorridors;
		}
		
		public void withTimeSlot(TimeSlot timeSlot){
			this.timeSlot = timeSlot;
		}

		public Floor build(){
			return new Floor(this);
		}
	}

	private Floor(Builder builder){
		this.floorNo = builder.floorNo;
		this.timeSlot = builder.timeSlot;
		this.mainCorridors = new ArrayList<>(builder.noOfMainCorridors*2+1);
		for(int j=1;j<=builder.noOfMainCorridors;j++){
			Corridor corridor = new MainCorridor(j, timeSlot);
			totalPowerConsumed += corridor.getEquipment().getPowerConsumed();
			this.mainCorridors.add(corridor);
		}
		this.subCorridors = new ArrayList<>(builder.noOfSubCorridors*2+1);
		for(int k=1;k<=builder.noOfSubCorridors;k++){
			Corridor corridor = new SubCorridor(k, timeSlot);
			totalPowerConsumed += corridor.getEquipment().getPowerConsumed();
			this.subCorridors.add(corridor);
		}
	}

	/**
	 * This method contains the logic to control the electronic equipments in the floor
	 * when movement is detected in the floor.
	 * 
	 * @param subCorridorNo
	 * @param maxPowerConsumption
	 */
	public void movementDetected(int subCorridorNo, int maxPowerConsumption){
		if(subCorridorNo>subCorridors.size()){
			throw new IllegalArgumentException("Sub corridor number cannot be greater than total number of sub corridor per floor");
		}
		Corridor detectedSubCorridor = subCorridors.get(subCorridorNo-1);
		
		//Reduce the initial power consumed by detected Sub Corridor
		totalPowerConsumed -= detectedSubCorridor.getEquipment().getPowerConsumed();
		
		detectedSubCorridor.movementDetected();
		
		//Add the power consumed by the equipment 
		//whose state has been changed due to Movement in the corridor
		totalPowerConsumed += detectedSubCorridor.getEquipment().getPowerConsumed();
		
		for (Corridor corridor: subCorridors){
			if(totalPowerConsumed>maxPowerConsumption){
				if(corridor.getCorridorNo()!=subCorridorNo){
					totalPowerConsumed -= corridor.getEquipment().switchOffEquipments();
				}
			}
			else{
				break;
			}
		}
		if(totalPowerConsumed>maxPowerConsumption){
			totalPowerConsumed -= detectedSubCorridor.getEquipment().switchOffEquipments();
		}	
	}

	/**
	 * This method contains the logic to control the electronic equipments in the floor
	 * when no movement is detected in the floor.
	 * 
	 * @param subCorridorNo
	 * @param maxPowerConsumption
	 */
	public void noMovementDetected(int subCorridorNo, int maxPowerConsumption){
		if(subCorridorNo>subCorridors.size()){
			throw new IllegalArgumentException("Sub corridor number cannot be greater than total number of sub corridor per floor");
		}
		Corridor detectedSubCorridor = subCorridors.get(subCorridorNo-1);
		totalPowerConsumed -= detectedSubCorridor.getEquipment().getPowerConsumed();
		detectedSubCorridor.noMovementDetected();
		totalPowerConsumed += detectedSubCorridor.getEquipment().getPowerConsumed();
		for (Corridor corridor: subCorridors){
			totalPowerConsumed += corridor.getEquipment().switchOnEquipments(maxPowerConsumption-totalPowerConsumed);		
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Floor ").append(floorNo).append("\n");
		for (Corridor corridor: mainCorridors) {			
			output.append(corridor.toString());
		}
		for (Corridor corridor: subCorridors) {		
			output.append(corridor.toString());
		}
		return output.toString();
	}

}
