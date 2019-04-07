package com.iss.buses.po;

public class Bus {
     private int id;
     private String name;
     private String owner;
     private String sname;
     private String number;
     private String safeid;
     private String stime;
     private String etime;
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSafeid() {
		return safeid;
	}
	public void setSafeid(String safeid) {
		this.safeid = safeid;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bus [id=" + id + ", name=" + name + ", owner=" + owner + ", sname=" + sname + ", number=" + number
				+ ", safeid=" + safeid + ", stime=" + stime + ", etime=" + etime + "]";
	}
	
     
}
