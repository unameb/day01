package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Stock;

public interface StockDao {
       @Select("select id,pid,partName,sum from stock where sshow=1")
       public List<Stock> allStock();
       @Update("update stock set sshow=0 where id=#{id}")
       public int delStock(@Param("id")int id);
       @Update("update stock set pid=#{pid},partName=#{partName},sum=#{sum} where id=#{id}")
       public int upStock(@Param("id")int id,@Param("pid")String pid,@Param("partName")String partName,@Param("sum")int sum);
       @Insert("insert into stock(pid,partName,sum) values(#{pid},#{partName},#{sum})")
       public int addStock(@Param("pid")String pid,@Param("partName")String partName,@Param("sum")int sum );
       
}
