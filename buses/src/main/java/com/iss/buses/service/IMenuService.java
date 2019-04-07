package com.iss.buses.service;

import java.util.List;


import com.iss.buses.po.Menu;

public interface IMenuService {
	 public List<Menu> mainMenu();
	 public List<Menu> subMenu(int pid);
}
