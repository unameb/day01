package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Fix;

public interface IFixService {
	 public List<Fix> allFix();
	 public int delFix(int id);
	 public int upFix(int bid,int driverid,String place,double cost,String partName,int number,String time,int id);
     public int addFix(int bid,int driverid,String place,double cost,String partName,int number,String time);
}
