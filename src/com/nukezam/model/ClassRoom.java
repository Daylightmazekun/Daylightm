package com.nukezam.model;

/**
 * Created by Glad Zekun Ma
 * */
public class ClassRoom {
	private String location;
	private String capacity;
	
	public ClassRoom(){
		super();
	}
	public ClassRoom(String location, String capacity){
		this.location = location;
		this.capacity = capacity;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
