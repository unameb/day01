package com.iss.buses.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.LoginDao;
import com.iss.buses.po.User;
import com.iss.buses.service.ILoginService;
@Service
public class LoginService implements ILoginService {
     @Resource
     private LoginDao dao;

	public User login(String uname, String upass) {
		// TODO Auto-generated method stub
		return dao.login(uname, upass);
	}

	@Override
	public int upUser(String newpwd, String uname) {
		// TODO Auto-generated method stub
		return dao.upUser(newpwd, uname);
	}
	
	

}
