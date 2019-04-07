package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.BackDao;
import com.iss.buses.po.Back;
import com.iss.buses.service.IBackService;
@Service
public class BackService implements IBackService {
     @Resource
     private BackDao dao;
	@Override
	public List<Back> allBack() {
		// TODO Auto-generated method stub
		return dao.allBack();
	}

	@Override
	public int delBack(int id) {
		// TODO Auto-generated method stub
		return dao.delBack(id);
	}

	@Override
	public int upBack(int id, int did, int bid, double income, double consumption, double run, String time) {
		// TODO Auto-generated method stub
		return dao.upBack(id, did, bid, income, consumption, run, time);
	}

	@Override
	public int addBack(int did, int bid, double income, double consumption, double run, String time) {
		// TODO Auto-generated method stub
		return dao.addBack(did, bid, income, consumption, run, time);
	}

}
