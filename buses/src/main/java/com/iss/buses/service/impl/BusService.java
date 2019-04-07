package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.BusDao;
import com.iss.buses.po.Bus;
import com.iss.buses.po.State;
import com.iss.buses.service.IBusService;
@Service
public class BusService implements IBusService {
      @Resource
      private BusDao dao;
      
	public List<Bus> allBus() {
		return dao.allBus();
	}

	public List<State> allState() {
		return dao.allState();
	}
	public int addBus(int id,int rid,int sid,String owner,String number,String safeid,String stime,String etime) {
		return dao.addBus(id, rid, owner, sid, number, safeid, stime, etime);
	}
	public int upBus(int id,int rid,int sid,String owner,String number,String safeid,String stime,String etime) {
		return dao.upBus(id, rid, owner, sid, number, safeid, stime, etime);
	}

	public int delBus(int id) {
		return dao.delBus(id);
	}
       
}
