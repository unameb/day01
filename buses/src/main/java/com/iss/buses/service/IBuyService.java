package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Buy;

public interface IBuyService {
	 public List<Buy> allBuy();
	 //删除
	 public int delBuy(String id);
      //更新
	 public int upBuy(String id,String partName,double partPrice,int partNum,double sumPrice);
	 //添加
	 public int addBuy(String id,String partName,double partPrice,int partNum,double sumPrice);

}

