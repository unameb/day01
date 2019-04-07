package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.BuyDao;
import com.iss.buses.po.Buy;
import com.iss.buses.service.IBuyService;
@Service
public class BuyService implements IBuyService {
      @Resource
      private BuyDao dao;
      
	public List<Buy> allBuy() {
		// TODO Auto-generated method stub
		return dao.allBuy();
	}
	public int delBuy(String id) {
		// TODO Auto-generated method stub
		return dao.delBuy(id);
	}
	public int upBuy(String id, String partName, double partPrice, int partNum, double sumPrice) {
		// TODO Auto-generated method stub
		return dao.upBuy(id, partName, partPrice, partNum, sumPrice);
	}
	public int addBuy(String id, String partName, double partPrice, int partNum, double sumPrice) {
		// TODO Auto-generated method stub
		return dao.addBuy(id, partName, partPrice, partNum, sumPrice);
	}


}
