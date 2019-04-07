package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Bus;
import com.iss.buses.po.Message;
import com.iss.buses.po.State;
import com.iss.buses.service.impl.BusService;

@Controller
public class BusController {
   @Resource
   private BusService service;
    
   private Message msg=new Message();
   
   @ResponseBody
   @RequestMapping("/allbus")
   public List<Bus> allBus(){
	   List<Bus> list=service.allBus();
	  System.out.println(list);
	   return list;
   }
   @ResponseBody
   @RequestMapping("/allstate")
   public List<State> allState(){
	   return service.allState();
   }
   @ResponseBody
   @RequestMapping("/addbus")
   public Message addBus(int id,int rid,int sid,String owner,String number,String safeid,String stime,String etime){
	   if(service.addBus(id, rid, sid, owner, number, safeid, stime, etime)>0){
		  msg.setFlag(true);
   		 msg.setMsg("添加成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("添加失败！");
   	 }
   	 return msg;   
   }
   @ResponseBody
   @RequestMapping("/upbus")
   public Message upBus(int id,int rid,int sid,String owner,String number,String safeid,String stime,String etime){
	   if(service.upBus(id, rid, sid, owner, number, safeid, stime, etime)>0){
		   msg.setFlag(true);
   		 msg.setMsg("修改成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("修改失败！");
   	 }
   	 return msg;   
   }
   @ResponseBody
   @RequestMapping("/delbus")
   public Message delBus(int id){
   	 if(service.delBus(id)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("删除成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("删除失败！");
   	 }
   	 return msg;
    }
}
