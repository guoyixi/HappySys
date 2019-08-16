package com.tj.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.user.HappysysUser;
import com.tj.service.HappySys_UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public int login(@RequestBody HappysysUser user) {
        int count = userservice.count(new QueryWrapper<HappysysUser>().eq("user_name", user.getUserName()).eq("user_password", user.getUserPassword()));
        System.out.println("count:" + count);
        return count;
    }

    @RequestMapping("/select/user")
    @ResponseBody
    public HappysysUser selectUser(@RequestBody HappysysUser user) {
        return userservice.getOne(new QueryWrapper<HappysysUser>().eq("user_name", user.getUserName()).eq("user_password", user.getUserPassword()));
    }

    @RequestMapping("/user/nameisExists")
    @ResponseBody
    public int nameisExists(@RequestBody String phone) {
        System.out.println("后台phone:" + phone);
        return userservice.count(new QueryWrapper<HappysysUser>().eq("user_name", phone));
    }

    @RequestMapping("/user/findbyname")
    @ResponseBody
    public HappysysUser findbyname(@RequestBody String username) {
        System.out.println("username:" + username);
        return userservice.getOne(new QueryWrapper<HappysysUser>().eq("user_name", username));
    }

    @RequestMapping("/HappysysUser/updateUserById")
    @ResponseBody
    public boolean updateUserById(@RequestBody HappysysUser user) {
        System.out.println("HappySys_UserController      updateUserById");
        return userservice.updateById(user);
    }

    @RequestMapping("/happysysUser/showAll/{pageIndex}/{usernamelike}")
    @ResponseBody
    public IPage<HappysysUser> showallUser(@PathVariable Integer pageIndex, @PathVariable String usernamelike) {
        if ("".equals(pageIndex)) {
            pageIndex = 1;
        }

        QueryWrapper<HappysysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("user_id");
        if (!usernamelike.equals("null") && !usernamelike.equals("")) {
            queryWrapper.like("user_name", usernamelike);
        }
        Page<HappysysUser> page = new Page<>(pageIndex, 2);
        IPage<HappysysUser> iPage = userservice.page(page, queryWrapper);
        return iPage;
    }

    @RequestMapping("/delbyid")
    @ResponseBody
    public Integer delbyId(@RequestBody Integer userId) {
        boolean user_id = userservice.remove(new QueryWrapper<HappysysUser>().eq("user_id", userId));
        if (user_id) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("/userfindbyid")
    @ResponseBody
    public HappysysUser finduserbyid(@RequestBody Integer userId) {
        System.out.println("userId;:"+userId);
        try{
            return   userservice.getOne(new QueryWrapper<HappysysUser>().eq("user_id", userId));
        }catch(Exception e){
            return null;
        }

    }

    @RequestMapping("/updateUser/{phone}/{riqi}/{sex}")
    @ResponseBody
    public boolean updateuser(@PathVariable(value = "phone") String phone,@PathVariable(value = "riqi") String riqi,@PathVariable(value = "sex") String sex,@RequestBody Integer userid) throws ParseException {
        System.out.println("nihao liutao");
        HappysysUser user=new HappysysUser();
        user.setUserId(userid);
        user.setUserName(phone);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        user.setUserBirthday(simpleDateFormat.parse(riqi));
        user.setUserSex(sex);
        return userservice.updateById(user);
    }
}