package com.iss.buses.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Message;
import com.iss.buses.po.Turn;
import com.iss.buses.service.ITurnService;


@Controller
public class TurnController {
     @Resource
     private ITurnService service;
     
     Message msg=new Message();
     
     @ResponseBody
     @RequestMapping("/allturn")
     public List<Turn> allTurn(){
  	   List<Turn> list=service.allTurn();
  	  System.out.println(list);
  	   return list;
     }
    
     @ResponseBody
     @RequestMapping("/addturn")
     public Message addTurn(int driver, int rid, String time, String station, int id){
  	   if(service.addTurn(driver, rid, time, station, id)>0){
  		  msg.setFlag(true);
     		 msg.setMsg("添加成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("添加失败！");
     	 }
     	 return msg;   
     }
     @ResponseBody
     @RequestMapping("/upturn")
     public Message upTurn(int driver, int rid, String time, String station, int id){
  	   if(service.upTurn(driver, rid, time, station, id)>0){
  		   msg.setFlag(true);
     		 msg.setMsg("修改成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("修改失败！");
     	 }
     	 return msg;   
     }
     @ResponseBody
     @RequestMapping("/delturn")
     public Message delTurn(int id){
     	 if(service.delTurn(id)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("删除成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("删除失败！");
     	 }
     	 return msg;
      }
}
