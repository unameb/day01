package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Turn;

public interface ITurnService {
	//查询
	public List<Turn> allTurn();
	//删除
	public int delTurn(int id);
	//修改
	public int upTurn(int driver,int rid,String time,String station,int id);
	//添加 
	public int addTurn(int driver,int rid,String time,String station,int id);
}
