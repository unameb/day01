package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Road;

public interface RoadDao {
	
      @Select("select id,name,start,end,length,stime,etime,sale from road where rshow=1")
      public List<Road> allRoad();
     @Update("update road set rshow=0 where id=#{id}")
      public int delRoad(@Param("id")int id);
      @Update("update road set name=#{name},start=#{start},end=#{end},length=#{length},stime=#{stime},etime=#{etime},sale=#{sale} where id=#{id}")
      public int upRoad(@Param("id")int id,@Param("name")String name,@Param("start")String start,@Param("end")String end,@Param("length")String length,@Param("stime")String stime,@Param("etime")String etime,@Param("sale")String sale);
      @Insert("insert into road values(#{id},#{name},#{start},#{end},#{length},#{stime},#{etime},#{sale},now(),1)")
      public int addRoad(@Param("id")int id,@Param("name")String name,@Param("start")String start,@Param("end")String end,@Param("length")String length,@Param("stime")String stime,@Param("etime")String etime,@Param("sale")String sale);
}
