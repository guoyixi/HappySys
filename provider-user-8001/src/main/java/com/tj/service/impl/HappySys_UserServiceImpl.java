package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.dao.HappySys_UserDao;

import com.tj.service.HappySys_UserService;
import com.tj.user.HappysysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HappySys_UserServiceImpl extends ServiceImpl<HappySys_UserDao, HappysysUser> implements HappySys_UserService {
    @Autowired
    private HappySys_UserDao userdao;

    public HappySys_UserServiceImpl() {
    }
}
