package com.tj.service;

import com.tj.user.HappysysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("HAPPY-USER")
public interface HappysysUserClientService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/add/user")
    public boolean addUser(HappysysUser user);

    /**
     * 根据条件username和password,返回count(*)
     * @param user
     * @return
     */
    @RequestMapping("/login/user")
    public int login(HappysysUser user);

    /**
     * 根据条件username和password,返回一个对象
     * @param user
     * @return
     */
    @RequestMapping("select/user")
    public HappysysUser showUser(HappysysUser user);

    /**
     * 根据usernmae判断是否存在，返回count(*)
     * @param phone
     * @return
     */
    @RequestMapping("user/nameisExists")
    public int isexists(String phone);

    /**
     * 根据条件username找对象
     * @param username
     * @return
     */
    @RequestMapping("user/findbyname")
    public HappysysUser findbyname(String username);

    /**
     *  根据userId修改用户
     * @param user
     * @return
     */
    @RequestMapping("/HappysysUser/updateUserById")
    boolean updateUserById(HappysysUser user);

}
