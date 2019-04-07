package com.iss.buses.service;

import java.util.List;

import com.iss.buses.po.Road;

public interface IRoadService {
	public List<Road> allRoad();
	//删除
	public int delRoad(int id);
	//修改
	public int upRoad(int id,String name,String start,String end,String length,String stime,String etime,String sale);
	//添加
	public int addRoad(int id,String name,String start,String end,String length,String stime,String etime,String sale);
    
}
