package com.iss.buses.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iss.buses.po.User;

public interface LoginDao {
      @Select("select id,uname,time from user where uname=#{uname} and upass=#{upass}")
      public User login(@Param("uname")String uname,@Param("upass")String upass);
      @Update("update user set upass=#{newpwd} where uname=#{uname}")
      public int upUser(@Param("newpwd")String newpwd,@Param("uname")String uname);

}
