package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.IInfoDao;
import com.iss.buses.po.Info;
import com.iss.buses.service.IInfoService;
@Service
public class InfoService implements IInfoService {
   @Resource
   private IInfoDao dao;

public List<Info> allInfo() {
	// TODO Auto-generated method stub
	return dao.allInfo();
}

public int delInfo(int id) {
	// TODO Auto-generated method stub
	return dao.delInfo(id);
}

public int addInfo(int id, String name, String tel, int sex, int age) {
	// TODO Auto-generated method stub
	return dao.addInfo(id, name, tel, sex, age);
}

public int upInfo(int id, String name, String tel, int sex, int age) {
	// TODO Auto-generated method stub
	return dao.upInfo(id, name, tel, sex, age);
}

}
