package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.RoadDao;
import com.iss.buses.po.Road;
import com.iss.buses.service.IRoadService;
@Service
public class RoadService implements IRoadService {
    @Resource
    private RoadDao dao;

	public List<Road> allRoad() {
		// TODO Auto-generated method stub
		return dao.allRoad();
	}

	public int delRoad(int id) {
		// TODO Auto-generated method stub
		return dao.delRoad(id);
	}

	public int upRoad(int id, String name, String start, String end, String length, String stime, String etime,
			String sale) {
		// TODO Auto-generated method stub
		return dao.upRoad(id, name, start, end, length, stime, etime, sale);
	}

	public int addRoad(int id, String name, String start, String end, String length, String stime, String etime,
			String sale) {
		// TODO Auto-generated method stub
		return dao.addRoad(id, name, start, end, length, stime, etime, sale);
	}
	
	

}
