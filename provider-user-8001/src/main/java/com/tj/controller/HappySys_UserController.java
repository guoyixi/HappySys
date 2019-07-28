package com.tj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.tj.user.HappysysUser;
import com.tj.service.HappySys_UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.net.ServerSocket;

@Controller
public class HappySys_UserController {
    @Autowired
    private HappySys_UserService userservice;

    public HappySys_UserController() {
    }


    @RequestMapping({"/add/user"})
    @ResponseBody
    public boolean addUser(@RequestBody HappysysUser user) {

        return this.userservice.save(user);
    }

    @RequestMapping("/login/user")
    @ResponseBody
    public int login(@RequestBody HappysysUser user){
        int count=userservice.count(new QueryWrapper<HappysysUser>().eq("user_name",user.getUserName()).eq("user_password",user.getUserPassword()));
        System.out.println("count:"+count);
        return count;
    }

    @RequestMapping("/select/user")
    @ResponseBody
    public HappysysUser selectUser(@RequestBody HappysysUser user){
       return  userservice.getOne(new QueryWrapper<HappysysUser>().eq("user_name",user.getUserName()).eq("user_password",user.getUserPassword()));
    }
    @RequestMapping("/user/nameisExists")
    @ResponseBody
    public int nameisExists(@RequestBody String phone){
        System.out.println("后台phone:"+phone);
        return userservice.count(new QueryWrapper<HappysysUser>().eq("user_name",phone));
    }

    @RequestMapping("/user/findbyname")
    @ResponseBody
    public HappysysUser findbyname(@RequestBody String username){
        System.out.println("username:"+username);
        return userservice.getOne(new QueryWrapper<HappysysUser>().eq("user_name",username));
    }

    @RequestMapping("/HappysysUser/updateUserById")
    @ResponseBody
    public boolean updateUserById(@RequestBody HappysysUser user){
        System.out.println("HappySys_UserController      updateUserById");
        return userservice.updateById(user);
    }

}
