package com.iss.buses.po;

public class Stock {
       private int id;
       private String pid;
       private String partName;
       private int sum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
       
}
