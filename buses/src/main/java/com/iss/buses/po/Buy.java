package com.iss.buses.po;

public class Buy {
     private String id;
     private String partName;
     private double partPrice;
     private int partNum;
     private double sumPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public double getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(double partPrice) {
		this.partPrice = partPrice;
	}
	public int getPartNum() {
		return partNum;
	}
	public void setPartNum(int partNum) {
		this.partNum = partNum;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public Buy() {
		super();
		// TODO Auto-generated constructor stub
	}
     
}
