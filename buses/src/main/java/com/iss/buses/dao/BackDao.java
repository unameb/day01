package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Back;

public interface BackDao {
      @Select("SELECT back.id, back.income,back.consumption,back.run,back.time,bus.id bid,info.`name` driver FROM back INNER JOIN bus ON back.bid = bus.id INNER JOIN info ON back.did = info.id WHERE back.bshow = 1")
      public List<Back> allBack();
      @Update("update back set bshow=0 where id=#{id}")
      public int delBack(@Param("id")int id);
      @Update("update back set did=#{did},bid=#{bid},income=#{income},consumption=#{consumption},run=#{run},time=#{time} where id=#{id} ")
      public int upBack(@Param("id")int id,@Param("did")int did,@Param("bid")int bid,@Param("income")double income,@Param("consumption")double consumption,@Param("run")double run,@Param("time")String time);
      @Insert("insert into back(did,bid,income,consumption,run,time) values(#{did},#{bid},#{income},#{consumption},#{run},#{time})")
      public int addBack(@Param("did")int did,@Param("bid")int bid,@Param("income")double income,@Param("consumption")double consumption,@Param("run")double run,@Param("time")String time);
}
