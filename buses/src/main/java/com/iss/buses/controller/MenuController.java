package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Menu;
import com.iss.buses.service.IMenuService;

@Controller
public class MenuController {
       @Resource
       private IMenuService ser;
       
       @ResponseBody
       @RequestMapping("/main")
       public List<Menu> mainMenu(){
    	   return ser.mainMenu();
       }
       
       @ResponseBody
       @RequestMapping("/sub")
       public List<Menu> subMenu(int pid){
    	   return ser.subMenu(pid);
       }
}
