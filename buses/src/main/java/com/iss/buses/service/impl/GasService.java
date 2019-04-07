package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.GasDao;
import com.iss.buses.po.Gas;
import com.iss.buses.service.IGasService;
@Service
public class GasService implements IGasService {
    @Resource
    private GasDao dao;
    
	@Override
	public List<Gas> allGas() {
		// TODO Auto-generated method stub
		return dao.allGas();
	}

	@Override
	public int delGas(int id) {
		// TODO Auto-generated method stub
		return dao.delGas(id);
	}

	@Override
	public int upGas(int id, double in, double out, double gas, String time) {
		// TODO Auto-generated method stub
		return dao.upGas(id, in, out, gas, time);
	}

	@Override
	public int addGas(int id, double in, double out, double gas, String time) {
		// TODO Auto-generated method stub
		return dao.addGas(id, in, out, gas, time);
	}

}
