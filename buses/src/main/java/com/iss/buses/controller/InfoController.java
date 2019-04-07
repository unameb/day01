package com.iss.buses.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Info;
import com.iss.buses.po.Message;
import com.iss.buses.service.IInfoService;

@Controller
public class InfoController {
    @Resource
    private IInfoService service;
    
    private Message msg=new Message();
    @ResponseBody
    @RequestMapping("/allinfo")
    public List<Info> allInfo(){
    	return service.allInfo();
    }
    @ResponseBody
    @RequestMapping("/addinfo")
    public Message addInfo(int id, String name, String tel, int sex, int age){
   	 if(service.addInfo(id, name, tel, sex, age)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("添加成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("添加失败！");
   	 }
   	 return msg;
    }
   
    @ResponseBody
    @RequestMapping("/delinfo")
    public Message delRoad(int id){
   	 if(service.delInfo(id)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("删除成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("删除失败！");
   	 }
   	 return msg;
    }
    @ResponseBody
    @RequestMapping("/upinfo")
    public Message upInfo(int id, String name, String tel, int sex, int age){
   	 if(service.upInfo(id, name, tel, sex, age)>0){
   		 msg.setFlag(true);
   		 msg.setMsg("修改成功！");
   	 }else{
   		 msg.setFlag(false);
   		 msg.setMsg("修改失败！");
   	 }
   	 return msg;
    } 
}
