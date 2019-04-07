package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Fix;
import com.iss.buses.po.Message;
import com.iss.buses.service.impl.FixService;

@Controller
public class FixController {
    @Resource
    private FixService service;
    private Message msg=new Message();
    
    @ResponseBody
    @RequestMapping("/allfix")
    public List<Fix> allFix(){
  	  return service.allFix();
    }
    @ResponseBody
    @RequestMapping("/addfix")
    public Message addFix(int bid, int driverid, String place, double cost, String partName, int number, String time){
  	  if(service.addFix(bid, driverid, place, cost, partName, number, time)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("添加成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("添加失败！");
   	 }
   	 return msg;
    }
   
    @ResponseBody
    @RequestMapping("/delfix")
    public Message delFix(int id){
   	 if(service.delFix(id)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("删除成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("删除失败！");
   	 }
   	 return msg;
    }
    @ResponseBody
    @RequestMapping("/upfix")
    public Message upFix(int bid, int driverid, String place, double cost, String partName, int number, String time,int id){
   	 if(service.upFix(bid, driverid, place, cost, partName, number, time, id)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("修改成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("修改失败！");
   	 }
   	 return msg;
    }  
}
