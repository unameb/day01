package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Bus;
import com.iss.buses.po.State;

public interface BusDao {
	@Select("select id,sname from state")
	public List<State> allState();
     @Select("SELECT bus.id,bus.owner,bus.number,bus.safeid,bus.stime,bus.etime,state.sname,road.name FROM state INNER JOIN bus ON bus.sid = state.id INNER JOIN road ON bus.rid = road.id where bshow=1")
     public List<Bus> allBus();
     @Insert("insert into bus values(#{id},#{rid},#{owner},#{sid},#{number},#{safeid},#{stime},#{etime},now(),1)")
     public int addBus(@Param("id")int id,@Param("rid")int rid,@Param("owner")String owner,@Param("sid")int sid,@Param("number")String number,@Param("safeid")String safeid,@Param("stime")String stime,@Param("etime")String etime);
     @Update("update bus set bshow=0 where id=#{id}")
     public int delBus(@Param("id")int id);
     @Update("update bus set rid=#{rid},owner=#{owner},sid=#{sid},number=#{number},safeid=#{safeid},stime=#{stime},etime=#{etime} where id=#{id}")
     public int upBus(@Param("id")int id,@Param("rid")int rid,@Param("owner")String owner,@Param("sid")int sid,@Param("number")String number,@Param("safeid")String safeid,@Param("stime")String stime,@Param("etime")String etime);
}
