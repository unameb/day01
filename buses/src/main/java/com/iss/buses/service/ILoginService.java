package com.iss.buses.service;

import com.iss.buses.po.User;

public interface ILoginService {
        public User login(String uname,String upass);
        public int upUser(String newpwd,String uname);
}
