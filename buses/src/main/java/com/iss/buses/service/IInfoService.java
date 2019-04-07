package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Info;

public interface IInfoService {
      public List<Info> allInfo();
      //删除
      public int delInfo(int id);
      //添加
      public int addInfo(int id,String name,String tel,int sex,int age);
      //修改
      public int upInfo(int id,String name,String tel,int sex,int age);
}
