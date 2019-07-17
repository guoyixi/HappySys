package com.tj.user;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
public class HappysysUser {
    @TableId
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer userIsadmin;
}
