package com.tj.user.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.service.HappysysUserClientService;
import com.tj.user.HappysysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;

@Controller
public class UserController {
    Integer userid=0;
    @Autowired
    public HappysysUserClientService userClientService;

    @RequestMapping("jin/userAll/{pageIndex}/{usernamelike}")
    public String userAll(@PathVariable Integer pageIndex, @PathVariable String usernamelike, Model model){
        Page<Map<String, Object>> mapPage = userClientService.showAllUser(pageIndex, usernamelike);
        model.addAttribute("usernamelike",usernamelike);
        model.addAttribute("mapPage",mapPage);
        return "admin-role";
    }

    @RequestMapping("ajax/jin/userAll/{pageIndex}/{usernamelike}")
    @ResponseBody
    public String ajaxuserAll(@PathVariable Integer pageIndex, @PathVariable String usernamelike){
        Page<Map<String, Object>> mapPage = userClientService.showAllUser(pageIndex, usernamelike);
        return JSON.toJSONString(mapPage);
    }

    @RequestMapping("/delbyid")
    @ResponseBody
    public Integer delbyid(Integer userId){
        return  userClientService.deletebyid(userId);
    }
    @RequestMapping("/userfindbyid")
    @ResponseBody
    public HappysysUser userfindbyid(){
        HappysysUser finduserbyid = userClientService.finduserbyid(userid);

        return finduserbyid;
    }

    @RequestMapping("/cunidsession/{id}")
    @ResponseBody
    public String aa(@PathVariable Integer id ){
        userid=id;
        return "ni";
    }



    @RequestMapping("/updateuser/{phone}/{riqi}/{sex}")
    @ResponseBody
    public boolean updateUser(@PathVariable String phone, @PathVariable String riqi, @PathVariable String sex){
        System.out.println("phone:"+phone+"\t:"+riqi+"\t:"+sex+":"+userid);
        return  userClientService.updateUser(phone,riqi,sex,userid);
    }



}
