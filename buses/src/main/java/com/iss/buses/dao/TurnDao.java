package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Turn;

public interface TurnDao {
       @Select("SELECT turn.id,turn.station,info.`name` driver,road.`name` road,turn.time FROM turn INNER JOIN info ON turn.driver = info.id INNER JOIN road ON turn.rid = road.id WHERE turn.tshow = 1")
       public List<Turn> allTurn();
       @Update("update turn set tshow=0 where id=#{id}")
       public int delTurn(@Param("id")int id);
       @Update("update turn set driver=#{driver},rid=#{rid},time=#{time},station=#{station} where id=#{id}")
       public int upTurn(@Param("driver")int driver,@Param("rid")int rid,@Param("time")String time,@Param("station")String station,@Param("id")int id);
       @Insert("insert into turn values(#{id},#{driver},#{rid},#{time},#{station},1)")
       public int addTurn(@Param("driver")int driver,@Param("rid")int rid,@Param("time")String time,@Param("station")String station,@Param("id")int id);
       
}
