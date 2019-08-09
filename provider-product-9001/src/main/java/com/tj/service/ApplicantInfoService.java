package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysApplicantInfo;

import java.util.List;

public interface ApplicantInfoService extends IService<HappysysApplicantInfo> {

 public List<HappysysApplicantInfo> findrecognizee();

}
