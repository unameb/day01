package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Gas;
import com.iss.buses.po.Message;
import com.iss.buses.service.impl.GasService;

@Controller
public class GasController {
      @Resource
      private GasService service;

      private Message msg=new Message();
      
      @ResponseBody
      @RequestMapping("/allgas")
      public List<Gas> allGas(){
    	  return service.allGas();
      }
      @ResponseBody
      @RequestMapping("/addgas")
      public Message addGas(int id,double in,double out,double gas,String time){
    	  if(service.addGas(id, in, out, gas, time)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("添加成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("添加失败！");
     	 }
     	 return msg;
      }
     
      @ResponseBody
      @RequestMapping("/delgas")
      public Message delGas(int id){
     	 if(service.delGas(id)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("删除成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("删除失败！");
     	 }
     	 return msg;
      }
      @ResponseBody
      @RequestMapping("/upgas")
      public Message upGas(int id,double in,double out,double gas,String time){
     	 if(service.upGas(id, in, out, gas, time)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("修改成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("修改失败！");
     	 }
     	 return msg;
      }  
}
