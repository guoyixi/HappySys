package com.tj.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.user.HappysysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.ValidationEvent;
import java.util.Map;

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

    /**
     * 查询所有用户带分页
     */
    @RequestMapping("/happysysUser/showAll/{pageIndex}/{usernamelike}")
    Page<Map<String,Object>> showAllUser(@PathVariable(value = "pageIndex") Integer pageIndex,@PathVariable(value = "usernamelike") String usernamelike);

    @RequestMapping("/delbyid")
    Integer deletebyid(Integer userId);

    @RequestMapping("/userfindbyid")
    HappysysUser finduserbyid(@RequestBody Integer userId);

    @RequestMapping("/updateUser/{phone}/{riqi}/{sex}")
    boolean updateUser(@PathVariable(value = "phone") String phone,@PathVariable(value = "riqi")  String riqi,@PathVariable(value = "sex")  String sex,@RequestBody Integer userid);
}
