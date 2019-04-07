package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.StockDao;
import com.iss.buses.po.Stock;
import com.iss.buses.service.IStockService;
@Service
public class StockService implements IStockService {
		@Resource
		private StockDao dao;
	
	@Override
	public List<Stock> allStock() {
		// TODO Auto-generated method stub
		return dao.allStock();
	}

	@Override
	public int delStock(int id) {
		// TODO Auto-generated method stub
		return dao.delStock(id);
	}

	@Override
	public int upStock(int id, String pid, String partName, int sum) {
		// TODO Auto-generated method stub
		return dao.upStock(id, pid, partName, sum);
	}

	@Override
	public int addStock(String pid, String partName, int sum) {
		// TODO Auto-generated method stub
		return dao.addStock(pid, partName, sum);
	}

}
