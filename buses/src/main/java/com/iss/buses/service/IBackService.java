package com.iss.buses.service;

import java.util.List;

import com.iss.buses.po.Back;

public interface IBackService {
	  public List<Back> allBack();
	  public int delBack(int id);
	  public int upBack(int id,int did,int bid,double income,double consumption,double run,String time);
      public int addBack(int did,int bid,double income,double consumption,double run,String time);
    
}
