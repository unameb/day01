package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Stock;
import com.iss.buses.po.Message;
import com.iss.buses.service.impl.StockService;

@Controller
public class StockController {
       @Resource
       private StockService service;
       private Message msg=new Message();
       
       @ResponseBody
       @RequestMapping("/allstock")
       public List<Stock> allStock(){
     	  return service.allStock();
       }
       @ResponseBody
       @RequestMapping("/addstock")
       public Message addStock(String pid, String partName, int sum){
     	  if(service.addStock(pid, partName, sum)>0){
      		 msg.setFlag(true);
      		 msg.setMsg("添加成功！");
      	 }else{
      		 msg.setFlag(false);
      		 msg.setMsg("添加失败！");
      	 }
      	 return msg;
       }
      
       @ResponseBody
       @RequestMapping("/delstock")
       public Message delStock(int id){
      	 if(service.delStock(id)>0){
      		 msg.setFlag(true);
      		 msg.setMsg("删除成功！");
      	 }else{
      		 msg.setFlag(false);
      		 msg.setMsg("删除失败！");
      	 }
      	 return msg;
       }
       @ResponseBody
       @RequestMapping("/upstock")
       public Message upStock(int id, String pid, String partName, int sum){
      	 if(service.upStock(id, pid, partName, sum)>0){
      		 msg.setFlag(true);
      		 msg.setMsg("修改成功！");
      	 }else{
      		 msg.setFlag(false);
      		 msg.setMsg("修改失败！");
      	 }
      	 return msg;
       }  
       
}
