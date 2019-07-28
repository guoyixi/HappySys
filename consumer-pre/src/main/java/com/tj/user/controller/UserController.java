package com.tj.user.controller;




import com.tj.service.HappysysProductClientService;
import com.tj.service.HappysysUserClientService;
import com.tj.user.HappysysUser;
import com.tj.user.shiro.MD5Pwd;
import com.tj.user.util.HttpClientUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RefreshScope
@Controller
public class UserController {
    @Autowired
    private HappysysUserClientService userClientService;

    @Autowired
    private HappysysProductClientService happysysProductClientService;

    @RequestMapping("/add/user")
    @ResponseBody
    public String addUser(HappysysUser user, String phone, String password){
        user.setUserName(phone);
        user.setUserPassword(MD5Pwd.MD5Pwd(phone,password));
        user.setUserIsadmin(1);
        boolean b = userClientService.addUser(user);
        return "login";
    }
    //用户名
    private static String Uid = "ironman";

    //接口安全秘钥
    private static String Key = "d41d8cd98f00b204e980";



    @RequestMapping("/generate/erweima")
    @ResponseBody
    public int erweima(String phone){
        System.out.println("进入erweima:"+phone);

        //手机号码，多个号码如13800000000,13800000001,13800000002
        String smsMob = phone;
        int notecode=(int)(Math.random()*(9999-1000+1)+1000);
        //短信内容
        String smsText = "亲爱的会员，您好！您的验证码是"+notecode+"，请您及时操作";
        System.out.println("随机数："+notecode);



        HttpClientUtil client = HttpClientUtil.getInstance();
        //UTF发送  还剩2条短信
      /*  int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result);
        }else{
            System.out.println(client.getErrorMsg(result));
        }*/
        return notecode;
    }

    @RequestMapping("/login")
    public String login(String account, String password, HappysysUser user, Model model, HttpSession session){
        System.out.println("dianhua:"+account+","+password);
        user.setUserName(account);
        user.setUserPassword(password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPassword());
        try {
            //登录
            System.out.println("登录。。。");
            ServletContext application=session.getServletContext();
            List<HappysysUser> lists=(List<HappysysUser>) application.getAttribute("users");
            for (HappysysUser hsu :lists){
                if(hsu.getUserName().contains(user.getUserName())){
                    model.addAttribute("mess","该用户已在线");
                    return "login";
                }
            }
            subject.login(token);
            System.out.println("token:"+token.getUsername());
            HappysysUser findbyname = userClientService.findbyname(token.getUsername());
            System.out.println("findbyname:"+findbyname.getUserIsadmin());
            if(findbyname.getUserIsadmin()==0){
                //进入后台
                return "houtai";
            }
            model.addAttribute("categoryList",happysysProductClientService.getCategoryAll());
            session.setAttribute("user",findbyname);
            //添加到在线用户集合
            lists.add(findbyname);
            return "index";
        }catch (UnknownAccountException e){
            //用户不存在
            model.addAttribute("mess","用户不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //密码不正确
            model.addAttribute("mess","密码不正确");
            return "login";
        }
      /*  user.setUserName(account);
        user.setUserPassword(password);
        ServletContext application=session.getServletContext();
        List<HappysysUser> lists=(List<HappysysUser>) application.getAttribute("users");
        for (HappysysUser hsu :lists){
            if(hsu.getUserName().contains(user.getUserName())){
                model.addAttribute("mess","该用户已在线");
                return "login";
            }
        }
        HappysysUser u=userClientService.showUser(user);

        if(u!=null){
            session.setAttribute("user",u);
            //添加到在线用户集合
            lists.add(u);
            if(u.getUserIsadmin()==1){
                System.out.println("准备进主页");
                return "index";
            }else{
                //进入后台
            }
        }
        System.out.println("失败了");
        model.addAttribute("mess","用户名或密码错误");
        return "login";*/

    }

    /*直接进入主页*/
    @RequestMapping("/")
    public String index(Model model){
        return  userIndex(model);
    }


    private String  userIndex(Model model){
        System.out.println("进入index主页。。。");
        model.addAttribute("categoryList",happysysProductClientService.getCategoryAll());
        return "index";
    }

    @RequestMapping("user/nameisExists")
    @ResponseBody
    public int nameisExists(String phone){
        System.out.println("phone:"+phone);
        int count=userClientService.isexists(phone);
        System.out.println("count:+"+count);
        return count;
    }



    @RequestMapping("/user/loadUserInfoShow")
    public HappysysUser loadUserInfoShow(String userName){
        System.out.println("UserController      loadUserInfoShow");

        return userClientService.findbyname(userName);
    }

    @RequestMapping(value = "/user/updateUserById")
    public ModelAndView updateUserById(HappysysUser user,@RequestParam(required = false) MultipartFile file,HttpSession session) {
        System.out.println("UserController      updateUserById");
        HappysysUser prototypeUser = (HappysysUser)session.getAttribute("user");

        System.out.println(user);

        //把session中的userId 赋值给要修改的id
        user.setUserId(prototypeUser.getUserId());

        boolean result = false;
        String resultMess = "修改用户资料失败，请联系管理员！";

        if (file.isEmpty()) {
            System.out.println("文件为空空哦");
            result = userClientService.updateUserById(user);
        }else {
            System.out.println("文件不为空空");
            //获取全文件名
            String fileName = file.getOriginalFilename();
            //截取后缀 ：.xxx
            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            List<String> suffixList = Arrays.asList(".png",".jpg",".jpeg",".webp",".bmp",".gif");
            if(!suffixList.contains(suffixName)){//判断是否不存在该后缀
                resultMess = "图片文件后缀必须为：.png、.jpg、.jpeg、.webp、.bmp、.gif、";
            }else{
                //把原来的userIon删除

                String filePath = "D:/S1S2Y2/Y2/IdeaWorkspace/happysys/consumer-pre/src/main/resources/static/images/usericon/"; // 上传后的路径
                // 新文件名
                fileName = UUID.randomUUID() + suffixName;
                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                user.setUserIcon(fileName);
                result = userClientService.updateUserById(user);
            }
        }
        if(result){ //如果修改成功就去数据库重新查出来
            session.setAttribute("user",userClientService.findbyname(prototypeUser.getUserName()));
            resultMess = "修改用户资料成功！";
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("resultMess",resultMess);
        mav.setViewName("user_info_show");

        return mav;
    }


}
