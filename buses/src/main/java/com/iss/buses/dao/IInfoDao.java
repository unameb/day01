package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.Info;

public interface IInfoDao {
	@Select("select id,name,sex,tel,age from info where ishow=1")
    public List<Info> allInfo();
	@Update("update info set ishow=0 where id=#{id}")
    public int delInfo(@Param("id")int id);
    @Update("update info set name=#{name},sex=#{sex},tel=#{tel},age=#{age} where id=#{id}")
    public int upInfo(@Param("id")int id,@Param("name")String name,@Param("tel")String tel,@Param("sex")int sex,@Param("age")int age);
    @Insert("insert into info values(#{id},#{name},#{sex},#{tel},#{age},now(),1)")
    public int addInfo(@Param("id")int id,@Param("name")String name,@Param("tel")String tel,@Param("sex")int sex,@Param("age")int age);
}
