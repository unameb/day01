package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Gas;

public interface IGasService {
	 public List<Gas> allGas();
     public int delGas(int id);
     public int upGas(int id,double in,double out,double gas,String time);
     public int addGas(int id,double in,double out,double gas,String time);
}
