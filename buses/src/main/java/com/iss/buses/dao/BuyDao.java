package com.iss.buses.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Buy;

public interface BuyDao {
	@Select("select id,partName,partPrice,partNum,sumPrice from buy where bshow=1")
    public List<Buy> allBuy();
	@Update("update buy set bshow=0 where id=#{id}")
    public int delBuy(@Param("id")String id);
    @Update("update buy set partName=#{partName},partPrice=#{partPrice},partNum=#{partNum},sumPrice=#{sumPrice} where id=#{id}")
    public int upBuy(@Param("id")String id,@Param("partName")String partName,@Param("partPrice")double partPrice,@Param("partNum")int partNum,@Param("sumPrice")double sumPrice);
    @Insert("insert into buy values(#{id},#{partName},#{partPrice},#{partNum},#{sumPrice},now(),1)")
    public int addBuy(@Param("id")String id,@Param("partName")String partName,@Param("partPrice")double partPrice,@Param("partNum")int partNum,@Param("sumPrice")double sumPrice);
}
