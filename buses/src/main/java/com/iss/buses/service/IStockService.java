package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Stock;

public interface IStockService {
    public List<Stock> allStock();
    public int delStock(int id);
    public int upStock(int id,String pid,String partName,int sum);
    public int addStock(String pid,String partName,int sum );
}
