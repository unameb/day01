package com.iss.buses.service;

import java.util.List;

import com.iss.buses.po.Bus;
import com.iss.buses.po.State;

public interface IBusService {
	//查询状态信息
	public List<State> allState();
	//查询车辆信息
	 public List<Bus> allBus();
	// 添加
	 public int addBus(int id,int rid,int sid,String owner,String number,String safeid,String stime,String etime);
	// 修改
	 public int upBus(int id,int rid,int sid,String owner,String number,String safeid,String stime,String etime);
	// 删除
	 public int delBus(int id);
}
