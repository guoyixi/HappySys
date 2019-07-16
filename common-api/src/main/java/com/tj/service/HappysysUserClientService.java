package com.tj.service;

import com.tj.user.HappysysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("HAPPY-USER")
public interface HappysysUserClientService {
    @RequestMapping("/add/user")
    public boolean addUser(HappysysUser user);

    @RequestMapping("/login/user")
    public int login(HappysysUser user);

    @RequestMapping("select/user")
    public HappysysUser showUser(HappysysUser user);
}
