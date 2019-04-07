package com.iss.buses.po;

public class Fix {
	private int id;
	private int bid;
     private String name;
     private String place;
     private double cost;
     private String partName;
     private int number;
     private String time;
     public int getId() {
    	 return id;
     }
     public void setId(int id) {
    	 this.id = id;
     }
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Fix() {
		super();
		// TODO Auto-generated constructor stub
	}
     
}
