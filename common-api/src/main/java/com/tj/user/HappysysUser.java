package com.tj.user;


import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HappysysUser implements Serializable {

    //`user_id`,`user_name`,`user_password`,`user_sex`,user_phone,`user_birthday`,`user_icon`,user_email,`user_isadmin`

    @TableId
    private Integer userId;
    private String userName;            //用户名
    private String userPassword;        //密码
    private String userEmail;          //邮箱

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date userBirthday;          //出生日期
    private String userSex;             //性别
    private String userPhone;           //电话号码
    private String userIcon;            //图标图片
    private Integer userIsadmin;        //是否是管理员
    private Integer userApplicantInfoId;



}
