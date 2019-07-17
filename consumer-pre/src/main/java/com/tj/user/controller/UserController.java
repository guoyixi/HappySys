package com.tj.user.controller;




import com.tj.service.HappysysUserClientService;
import com.tj.user.HappysysUser;
import com.tj.user.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private HappysysUserClientService userClientService;

    @RequestMapping("/add/user")
    public String addUser(HappysysUser user, String phone, String password){
        user.setUserName(phone);
        user.setUserPassword(password);
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
        //int login = userClientService.login(user);
        HappysysUser u=userClientService.showUser(user);
        if(u!=null){
            //存入一个对象
            session.setAttribute("happysysUser",u);
            if(u.getUserIsadmin()==1){
                System.out.println("准备进主页");
                return "index";
            }else{
                //进入后台
            }
        }
        System.out.println("失败了");
        model.addAttribute("mess","用户名或密码错误");
        return "login";

    }

    /*直接进入主页*/
    @RequestMapping("/")
    public String index(){
       return  userIndex();
    }


    private String  userIndex(){
        System.out.println("进入index主页。。。");
        return "index";
    }
}
