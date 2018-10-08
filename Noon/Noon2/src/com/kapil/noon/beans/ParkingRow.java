package com.kapil.noon.beans;

import java.util.Map;

import com.kapil.noon.enums.SpotEnum;

public class ParkingRow {

	private int rowNum;
	
	private Map<SpotEnum, Integer> spotMap;

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public Map<SpotEnum, Integer> getSpotMap() {
		return spotMap;
	}

	public void setSpotMap(Map<SpotEnum, Integer> spotMap) {
		this.spotMap = spotMap;
	}
}
