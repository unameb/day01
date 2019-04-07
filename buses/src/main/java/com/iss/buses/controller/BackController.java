package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Back;
import com.iss.buses.po.Message;
import com.iss.buses.service.IBackService;

@Controller
public class BackController {
      @Resource
      private IBackService service;
      
      private Message msg=new Message();
      
      @ResponseBody
      @RequestMapping("/allback")
      public List<Back> allBack(){
    	  return service.allBack();
      }
      @ResponseBody
      @RequestMapping("/addback")
      public Message addBack(int did, int bid, double income, double consumption, double run, String time){
    	  if(service.addBack(did, bid, income, consumption, run, time)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("添加成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("添加失败！");
     	 }
     	 return msg;
      }
     
      @ResponseBody
      @RequestMapping("/delback")
      public Message delBack(int id){
     	 if(service.delBack(id)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("删除成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("删除失败！");
     	 }
     	 return msg;
      }
      @ResponseBody
      @RequestMapping("/upback")
      public Message upBack(int id, int did, int bid, double income, double consumption, double run, String time){
     	 if(service.upBack(id, did, bid, income, consumption, run, time)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("修改成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("修改失败！");
     	 }
     	 return msg;
      }  
}
