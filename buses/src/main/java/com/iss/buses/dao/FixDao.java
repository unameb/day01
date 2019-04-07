package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Fix;

public interface FixDao {
        @Select("SELECT fix.id,fix.place,fix.cost,fix.number,fix.time,info.`name`,fix.partName,fix.bid FROM fix "
        		+ "INNER JOIN info ON fix.driverid = info.id "
        		+ "INNER JOIN bus ON fix.bid = bus.id WHERE fix.fshow = 1")
        public List<Fix> allFix();
        @Update("update fix set fshow=0 where id=#{id}")
        public int delFix(@Param("id")int id);
        @Update("update fix set bid=#{bid},driverid=#{driverid},place=#{place},cost=#{cost},partName=#{partName},number=#{number},time=#{time} where id=#{id}")
        public int upFix(@Param("bid")int bid,@Param("driverid")int driverid,@Param("place")String place,@Param("cost")double cost,@Param("partName")String partName,@Param("number")int number,@Param("time")String time,@Param("id")int id);
        @Insert("insert into fix(bid,driverid,place,cost,partName,number,time) values(#{bid},#{driverid},#{place},#{cost},#{partName},#{number},#{time})")
        public int addFix(@Param("bid")int bid,@Param("driverid")int driverid,@Param("place")String place,@Param("cost")double cost,@Param("partName")String partName,@Param("number")int number,@Param("time")String time);

}
