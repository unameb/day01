package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.TurnDao;
import com.iss.buses.po.Turn;
import com.iss.buses.service.ITurnService;
@Service
public class TurnService implements ITurnService {
      @Resource
      private TurnDao dao;
	public List<Turn> allTurn() {
		return dao.allTurn();
	}

	public int delTurn(int id) {
		return dao.delTurn(id);
	}

	public int upTurn(int driver, int rid, String time, String station, int id) {
		return dao.upTurn(driver, rid, time, station, id);
	}

	public int addTurn(int driver, int rid, String time, String station, int id) {
		return dao.addTurn(driver, rid, time, station, id);
	}

}
