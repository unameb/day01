package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Buy;
import com.iss.buses.po.Message;
import com.iss.buses.service.IBuyService;
import com.iss.buses.service.IStockService;

@Controller
public class BuyController {
      @Resource
      private IBuyService service;
      
      @Resource
      private IStockService ser;
      private Message msg=new Message();
      @ResponseBody
      @RequestMapping("/allbuy")
      public List<Buy> allBuy(){
    	  return service.allBuy();
      }
      @ResponseBody
      @RequestMapping("/addbuy")
      public Message addBuy(String id,String partName,double partPrice,int partNum){
    	  double sumPrice=partPrice*partNum;
    	  if(service.addBuy(id, partName, partPrice, partNum, sumPrice)>0){
    		     if(ser.addStock(id, partName, partNum)>0){
     		               msg.setFlag(true);
     		               msg.setMsg("添加成功！");}
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("添加失败！");
     	 }
     	 return msg;
      }
     
      @ResponseBody
      @RequestMapping("/delbuy")
      public Message delBuy(String id){
     	 if(service.delBuy(id)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("删除成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("删除失败！");
     	 }
     	 return msg;
      }
      @ResponseBody
      @RequestMapping("/upbuy")
      public Message upBuy(String id,String partName,double partPrice,int partNum){
    	  double sumPrice=partPrice*partNum;
     	 if(service.upBuy(id, partName, partPrice, partNum, sumPrice)>0){
     		 msg.setFlag(true);
     		 msg.setMsg("修改成功！");
     	 }else{
     		 msg.setFlag(false);
     		 msg.setMsg("修改失败！");
     	 }
     	 return msg;
      }  

}
