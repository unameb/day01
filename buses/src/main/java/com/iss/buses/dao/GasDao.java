package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Gas;

public interface GasDao {
       @Select("select * from gas where gshow=1")
       public List<Gas> allGas();
       @Update("update gas set gshow=0 where id=#{id}")
       public int delGas(@Param("id")int id);
       @Update("update gas set income=#{in},outcome=#{out},gas=#{gas},time=#{time} where id=#{id}")
       public int upGas(@Param("id")int id,@Param("in")double in,@Param("out")double out,@Param("gas")double gas,@Param("time")String time);
       @Insert("insert into gas values(#{id},#{in},#{out},#{gas},#{time},1)")
       public int addGas(@Param("id")int id,@Param("in")double in,@Param("out")double out,@Param("gas")double gas,@Param("time")String time);
}
