package com.iss.buses.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.buses.po.Message;
import com.iss.buses.po.User;
import com.iss.buses.service.ILoginService;

@Controller
public class LoginController {
          @Resource
          private ILoginService ser;
          
          private Message msg=new Message();
          
          @ResponseBody
          @RequestMapping("/lg")
          public Message login(String uname,String upass){
        	  User user=ser.login(uname, upass);
        	  if(user!=null){
        		  msg.setFlag(true);
        	  }else{
        		  msg.setFlag(false);
        		  msg.setMsg("用户名或密码错误！");
        	  }
        	  return msg;
          }
          @ResponseBody
          @RequestMapping("/change")
          public Message Change(String uname,String upass,String newpwd){
        	  User user=ser.login(uname, upass);
        	  if(user!=null){
        		  if(ser.upUser(newpwd, uname)>0){
        		  msg.setFlag(true);
        		  msg.setMsg("修改密码成功！");
        		  }
        		  else{
        			  msg.setFlag(false);
            		  msg.setMsg("修改密码错误！");
        		  }
        	  }else{
        		  msg.setFlag(false);
        		  msg.setMsg("用户名或密码错误！");
        	  }
        	  return msg;
          }  
          
          
}
