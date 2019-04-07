package com.iss.buses.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iss.buses.po.Menu;

public interface MenuDao {
      @Select("SELECT main.id,main.title,main.pid,main.did,main.oid FROM main WHERE main.pid = 0 AND main.did = 1 ORDER BY main.oid DESC")
      public List<Menu> mainMenu();
      @Select("SELECT main.id,main.title,main.pid,main.did,main.oid,main.path,main.icon FROM main WHERE main.pid =#{pid} ORDER BY main.oid DESC")
      public List<Menu> subMenu(@Param("pid") int pid);
}
