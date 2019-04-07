package com.iss.buses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iss.buses.dao.MenuDao;
import com.iss.buses.po.Menu;
import com.iss.buses.service.IMenuService;
@Service
public class MenuService implements IMenuService {
    @Resource
    private MenuDao dao;

	public List<Menu> mainMenu() {
		// TODO Auto-generated method stub
		return dao.mainMenu();
	}

	public List<Menu> subMenu(int pid) {
		// TODO Auto-generated method stub
		return dao.subMenu(pid);
	}
	

}
