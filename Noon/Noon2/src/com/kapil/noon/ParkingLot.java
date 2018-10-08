package com.kapil.noon;

import java.util.List;

import com.kapil.noon.enums.SpotEnum;
import com.kapil.noon.enums.VehicleEnum;

public class ParkingLot {

	//SpotList will be Concurrent 
	
	public void acquireSpot(VehicleEnum vehicle) {
		//check for available spot
		// if spot not available - sysout "Spot Not Available"
		//else fillMap(VehicleEnum, List of Spots available)
		//Reduce spotList with these spots
	}

	public void releaseSpot(VehicleEnum vehicle) {
		//Get Spots acquired by this vehicle from the map
		//Increase SpotList with these spots
		//remove key from map VehicleEnum
	}

	public List<SpotEnum> checkForAvailableSpot(VehicleEnum vehicle) {
		//available spot List
		//Check for no. of spots required to accustom this vehicle.
		//if spots available return that list else 
		//return null
		return null;
	}
	
	
	//LinkedHashMap<SpotEnum, LinkedList<SpotClass>> map
	//add -> level - rowNum -> SpotEnum based
	
}
