package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.FixDao;
import com.iss.buses.po.Fix;
import com.iss.buses.service.IFixService;
@Service
public class FixService implements IFixService {
       @Resource
       private FixDao dao;
	@Override
	public List<Fix> allFix() {
		// TODO Auto-generated method stub
		return dao.allFix();
	}

	@Override
	public int delFix(int id) {
		// TODO Auto-generated method stub
		return dao.delFix(id);
	}

	@Override
	public int upFix(int bid, int driverid, String place, double cost, String partName, int number, String time,
			int id) {
		// TODO Auto-generated method stub
		return dao.upFix(bid, driverid, place, cost, partName, number, time, id);
	}

	@Override
	public int addFix(int bid, int driverid, String place, double cost, String partName, int number, String time) {
		// TODO Auto-generated method stub
		return dao.addFix(bid, driverid, place, cost, partName, number, time);
	}

}
