package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Message;
import com.iss.buses.po.Road;
import com.iss.buses.service.IRoadService;

@Controller
public class RoadController {
         @Resource
         private IRoadService service;
         
         private Message msg=new Message();
         
         @ResponseBody
         @RequestMapping("/allroad")
         public List<Road> allRoad(){
        	 return service.allRoad();
         }
        @ResponseBody
         @RequestMapping("/addroad")
         public Message addRoad(int id,String name,String start,String end,String length,String stime,String etime,String sale){
        	 if(service.addRoad(id,name,start,end,length,stime,etime,sale)>0){
        		 msg.setFlag(true);
        		 msg.setMsg("添加成功！");
        	 }else{
        		 msg.setFlag(false);
        		 msg.setMsg("添加失败！");
        	 }
        	 return msg;
         }
        
         @ResponseBody
         @RequestMapping("/delroad")
         public Message delRoad(int id){
        	 if(service.delRoad(id)>0){
        		 msg.setFlag(true);
        		 msg.setMsg("删除成功！");
        	 }else{
        		 msg.setFlag(false);
        		 msg.setMsg("删除失败！");
        	 }
        	 return msg;
         }
         @ResponseBody
         @RequestMapping("/uproad")
         public Message upRoad(int id,String name,String start,String end,String length,String stime,String etime,String sale){
        	 if(service.upRoad(id,name,start,end,length,stime,etime,sale)>0){
        		 msg.setFlag(true);
        		 msg.setMsg("修改成功！");
        	 }else{
        		 msg.setFlag(false);
        		 msg.setMsg("修改失败！");
        	 }
        	 return msg;
         }
         
}
